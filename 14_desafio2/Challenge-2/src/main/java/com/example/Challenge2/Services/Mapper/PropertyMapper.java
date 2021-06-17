package com.example.Challenge2.Services.Mapper;

import com.example.Challenge2.Models.Property;
import com.example.Challenge2.Models.Room;
import com.example.Challenge2.Services.DTOs.PropertyDTO;
import com.example.Challenge2.Services.DTOs.RoomDTO;


public class PropertyMapper {

    public static PropertyDTO toDTO(Property property){

        return new PropertyDTO(property.getName(),RoomMapper.toDTOs(property.getRooms()),property.getDistrictId());
    }
    public static Room toDRoom(RoomDTO roomDTO){
        return new Room(roomDTO.getName(),roomDTO.getWidth(),roomDTO.getLength());
    }

}
