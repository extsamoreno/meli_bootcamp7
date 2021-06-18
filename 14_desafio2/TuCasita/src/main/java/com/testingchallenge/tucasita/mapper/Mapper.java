package com.testingchallenge.tucasita.mapper;

import com.testingchallenge.tucasita.dto.PropertyDTO;
import com.testingchallenge.tucasita.dto.PropertyReqDTO;
import com.testingchallenge.tucasita.dto.RoomDTO;
import com.testingchallenge.tucasita.model.Neighborhood;
import com.testingchallenge.tucasita.model.Property;
import com.testingchallenge.tucasita.model.Room;

public class Mapper {

    // from model to DTO
    public static PropertyDTO toDTO (Property property, double area) {
        PropertyDTO propertyDTO = new PropertyDTO();
        propertyDTO.setName(property.getName());
        propertyDTO.setArea(area);
        return propertyDTO;
    }

    public static RoomDTO toDTO (Room room) {
        RoomDTO roomDTO = new RoomDTO();
        roomDTO.setName(room.getName());
        roomDTO.setArea(room.getLength() * room.getWidth() * 1.0);

        return roomDTO;
    }

    // from a requestDTO to a model
    public static Property toProperty (PropertyReqDTO propertyReqDTO, Neighborhood neighborhood) {
        Property property = new Property();
        property.setName(propertyReqDTO.getName());
        property.setNeighborhood(neighborhood);
        property.setRoomList(propertyReqDTO.getRoomList());
        return property;
    }

}
