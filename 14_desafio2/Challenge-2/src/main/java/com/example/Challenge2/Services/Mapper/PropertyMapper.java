package com.example.Challenge2.Services.Mapper;

import com.example.Challenge2.Models.Property;
import com.example.Challenge2.Models.Room;
import com.example.Challenge2.Services.DTOs.PropertyDTO;
import com.example.Challenge2.Services.DTOs.RoomDTO;


public class PropertyMapper {

    public static PropertyDTO toDTO(Property property){

        return new PropertyDTO(property.getName(),RoomMapper.toDTOs(property.getRooms()),property.getDistrictId());
    }

    public static Property toProperty(PropertyDTO property){

        return new Property(property.getName(),null,RoomMapper.toRooms(property.getRooms()), property.getDistrictId());
    }


}
