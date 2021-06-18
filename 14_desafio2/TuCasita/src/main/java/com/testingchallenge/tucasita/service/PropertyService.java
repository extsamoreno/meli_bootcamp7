package com.testingchallenge.tucasita.service;

import com.testingchallenge.tucasita.dto.*;
import com.testingchallenge.tucasita.exception.NeighborhoodNotFoundException;
import com.testingchallenge.tucasita.exception.PropertyNotFoundException;
import com.testingchallenge.tucasita.mapper.Mapper;
import com.testingchallenge.tucasita.model.Neighborhood;
import com.testingchallenge.tucasita.model.Property;
import com.testingchallenge.tucasita.model.Room;
import com.testingchallenge.tucasita.repository.iNeighborhoodRepository;
import com.testingchallenge.tucasita.repository.iPropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropertyService implements iPropertyService {
    @Autowired
    iPropertyRepository iPropertyRepository;

    @Autowired
   iNeighborhoodRepository iNeighborhoodRepository;

    @Override
    public PropertyDTO getArea (String name) throws PropertyNotFoundException {
        Property property = iPropertyRepository.getByName(name);
        double area = calculateArea(property);
        return Mapper.toDTO(property, area);
    }
    // aux
    public double calculateArea (Property property) {
        List<Room> roomList = property.getRoomList();
        double areaSummary;
        areaSummary = roomList.stream()
                .mapToDouble(room -> room.getWidth() * room.getLength() * 1.0)
                .sum();
        return areaSummary;
    }

    @Override
    public PropertyValueDTO getValue (String name) throws PropertyNotFoundException {
        Property property = iPropertyRepository.getByName(name);
        double meterValue = property.getNeighborhood().getPrice();
        double areaSummary = calculateArea(property);

        PropertyValueDTO propertyValueDTO = new PropertyValueDTO();
        propertyValueDTO.setName(property.getName());
        propertyValueDTO.setPrice(meterValue * areaSummary * 1.0);

        return propertyValueDTO;
    }

    @Override
    public PropertyRoomsDTO getRoomArea (String name) throws PropertyNotFoundException {
        Property property = iPropertyRepository.getByName(name);
        List<Room> roomList = property.getRoomList();

        PropertyRoomsDTO propertyRoomsDTO = new PropertyRoomsDTO();
        propertyRoomsDTO.setName(property.getName());

        Room room = null;
        for (int i = 0; i < roomList.size(); i++) {
            room = roomList.get(i);
            propertyRoomsDTO.addRoom(new RoomDTO(
                    room.getName(), room.getLength() * room.getWidth()
            ));
        }
        return propertyRoomsDTO;
    }

    @Override
    public BiggerRoomDTO getTheBiggerRoom(String name) throws PropertyNotFoundException {
        Property property = iPropertyRepository.getByName(name);

        BiggerRoomDTO biggerRoomDTO = new BiggerRoomDTO();
        biggerRoomDTO.setName(property.getName());
        biggerRoomDTO.setRoom(Mapper.toDTO(findTheBiggerRoom(property)));

        return biggerRoomDTO;
    }
    // aux
    public Room findTheBiggerRoom (Property property) {
        List<Room> roomList = property.getRoomList();
        Room biggerOne = roomList.stream()
                .reduce((a, b) ->
                        a.getLength() * a.getWidth() * 1.0 >=
                                b.getLength() * b.getWidth() * 1.0
                ? a : b)
                .get();
        return biggerOne;
    }

    @Override
    public HttpStatus addProperty (PropertyReqDTO propertyReqDTO) throws NeighborhoodNotFoundException {
        Neighborhood neighborhood = iNeighborhoodRepository.getByName(propertyReqDTO.getNeighborhood());
        Property aNewProperty = Mapper.toProperty(propertyReqDTO, neighborhood);
        return iPropertyRepository.addProperty(aNewProperty);
    }

}
