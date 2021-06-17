package com.example.DesafioTasaciones.services;

import com.example.DesafioTasaciones.dtos.HouseDTO;
import com.example.DesafioTasaciones.dtos.ResponseDTO;
import com.example.DesafioTasaciones.dtos.RoomDTO;
import com.example.DesafioTasaciones.exceptions.DistrictNotFound;
import com.example.DesafioTasaciones.models.District;
import com.example.DesafioTasaciones.models.House;
import com.example.DesafioTasaciones.models.Room;
import com.example.DesafioTasaciones.repository.IHouseRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.modelmapper.ModelMapper.*;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class HouseService implements IHouseService {


    ModelMapper mapper;

    @Autowired
    IHouseRepository iHouseRepository;

    @Override
    public ResponseDTO totalSquareMeters(Integer propertyId) {
        House house = iHouseRepository.findPropertyById(propertyId);

        ResponseDTO response = new ResponseDTO();
        response.setTotalSquareMeters(this.calculateTotalSquareMeters(house.getRooms()));
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
        House house = iHouseRepository.findPropertyById(propertyId);
        Double propertyValue = calculateTotalSquareMeters(house.getRooms()) * house.getDistrict().getPrice();

        ResponseDTO response = new ResponseDTO();
        response.setPropertyValue(propertyValue);
        return response;
    }

    @Override
    public ResponseDTO largestEnvironment(Integer propertyId) {
        House house = iHouseRepository.findPropertyById(propertyId);
        RoomDTO roomDTO = findBiggestEnvironment(house.getRooms());

        ResponseDTO response = new ResponseDTO();
        response.setLargestEnvironment(roomDTO);
        return response;
    }

    private RoomDTO findBiggestEnvironment(List<Room> rooms) {
        Optional<Room> largestRoom = rooms.stream().max((room1, room2) -> (int) (calculateSquareMeters(room1) - (calculateSquareMeters(room2))));
        return largestRoom.map(room -> mapper.map(rooms, RoomDTO.class)).orElse(null);
    }

    @Override
    public ResponseDTO roomsSquareMeters(Integer propertyId) {
        House house = iHouseRepository.findPropertyById(propertyId);

        ResponseDTO response = new ResponseDTO();
        response.setRoomsSquareMeters(getEnvironmentsDTO(house.getRooms()));
        return response;
    }

    private List<RoomDTO> getEnvironmentsDTO(List<Room> rooms) {
        List<RoomDTO> roomsDTOS = new ArrayList<>();
        for(Room room : rooms) {
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
    public void createProperty(HouseDTO house) {
        District district = iHouseRepository.findDistrictByName(house.getDistrictName());

        if(district == null) {
            throw new DistrictNotFound(house.getDistrictName());
        }

        House newHouse = mapper.map(house,House.class);
        newHouse.setDistrict(district);
        iHouseRepository.saveProperty(newHouse);
    }

    @Override
    public List<HouseDTO> getAllProperties() {
        List<House> house = iHouseRepository.getAllProperties();
        List<HouseDTO> propertyDTOS = new ArrayList<>();

        for(House h : house) {
            propertyDTOS.add(mapper.map(h,HouseDTO.class));
        }
        return propertyDTOS;
    }
}
