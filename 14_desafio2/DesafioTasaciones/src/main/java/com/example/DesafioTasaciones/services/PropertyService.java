package com.example.DesafioTasaciones.services;

import com.example.DesafioTasaciones.dtos.PropertyDTO;
import com.example.DesafioTasaciones.dtos.ResponseDTO;
import com.example.DesafioTasaciones.dtos.RoomDTO;
import com.example.DesafioTasaciones.exceptions.DistrictNotFound;
import com.example.DesafioTasaciones.models.District;
import com.example.DesafioTasaciones.models.Property;
import com.example.DesafioTasaciones.models.Room;
import com.example.DesafioTasaciones.repository.IPropertyRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PropertyService implements IPropertyService {


    ModelMapper mapper;

    @Autowired
    IPropertyRepository iPropertyRepository;

    @Override
    public ResponseDTO totalSquareMeters(Integer propertyId) {
        Property property = iPropertyRepository.findPropertyById(propertyId);

        ResponseDTO response = new ResponseDTO();
        response.setTotalSquareMeters(this.calculateTotalSquareMeters(property.getRooms()));
        return response;
    }

    private Double calculateTotalSquareMeters(List<Room> environments) {
        return environments.stream().mapToDouble(this::calculateSquareMeters).sum();
    }

    private double calculateSquareMeters(Room rooms) {
        return rooms.getWidth() * rooms.getLength();
    }

    @Override
    public ResponseDTO propertyValue(Integer propertyId) {
        Property property = iPropertyRepository.findPropertyById(propertyId);
        Double propertyValue = calculateTotalSquareMeters(property.getRooms()) * property.getDistrict().getPrice();

        ResponseDTO response = new ResponseDTO();
        response.setPropertyValue(propertyValue);
        return response;
    }

    @Override
    public ResponseDTO largestEnvironment(Integer propertyId) {
        Property property = iPropertyRepository.findPropertyById(propertyId);
        RoomDTO roomDTO = findBiggestEnvironment(property.getRooms());

        ResponseDTO response = new ResponseDTO();
        response.setLargestEnvironment(roomDTO);
        return response;
    }

    @Override
    public RoomDTO findBiggestEnvironment(List<Room> rooms) {
        Room room = null;
        if (rooms.size() > 0) {

            if (rooms.size() == 1) {
                room = rooms.get(1);
            } else {
                for (int i = 0; i < rooms.size(); i++) {
                    if (i == 0) {
                        room = rooms.get(0);
                    } else {
                        if (room.getWidth() * room.getLength() < rooms.get(i).getLength() * rooms.get(i).getWidth()) {
                            room = rooms.get(i);
                        }
                    }
                }
            }
        }
        mapper = new ModelMapper();

        return mapper.map(room, RoomDTO.class);
    }

    @Override
    public ResponseDTO roomsSquareMeters(Integer propertyId) {
        Property property = iPropertyRepository.findPropertyById(propertyId);

        ResponseDTO response = new ResponseDTO();
        response.setRoomsSquareMeters(getEnvironmentsDTO(property.getRooms()));
        return response;
    }

    private List<RoomDTO> getEnvironmentsDTO(List<Room> rooms) {
        List<RoomDTO> roomsDTOS = new ArrayList<>();
        for (Room room : rooms) {
            roomsDTOS.add(createEnvironmentDTO(room));
        }
        return roomsDTOS;
    }

    private RoomDTO createEnvironmentDTO(Room room) {
        RoomDTO roomsDTOS = new RoomDTO();
        roomsDTOS.setName(room.getName());
        roomsDTOS.setSquareMeters(calculateSquareMeters(room));
        return roomsDTOS;
    }

    @Override
    public void createProperty(PropertyDTO house) {
        District district = iPropertyRepository.findDistrictByName(house.getDistrictName());

        if (district == null) {
            throw new DistrictNotFound(house.getDistrictName());
        }

        mapper = new ModelMapper();
        Property newProperty = mapper.map(house, Property.class);
        newProperty.setDistrict(district);
        iPropertyRepository.saveProperty(newProperty);
    }

    @Override
    public List<PropertyDTO> getAllProperties() {
        List<Property> property = iPropertyRepository.getAllProperties();
        List<PropertyDTO> propertyDTOS = new ArrayList<>();

        for (Property h : property) {
            propertyDTOS.add(mapper.map(h, PropertyDTO.class));
        }
        return propertyDTOS;
    }
}
