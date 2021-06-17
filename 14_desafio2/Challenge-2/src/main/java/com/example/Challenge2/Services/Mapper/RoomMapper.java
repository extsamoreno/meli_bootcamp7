package com.example.Challenge2.Services.Mapper;

import com.example.Challenge2.Models.District;
import com.example.Challenge2.Models.Room;
import com.example.Challenge2.Services.DTOs.DistrictDTO;
import com.example.Challenge2.Services.DTOs.RoomDTO;

import java.util.ArrayList;
import java.util.List;


public class RoomMapper {

    public static RoomDTO toDTO(Room room){
        return new RoomDTO(room.getName(), room.getWidth(),room.getLength());
    }

    public static Room toRoom(RoomDTO room){

        return new Room(room.getName(), room.getWidth(),room.getLength());
    }


    public static List<RoomDTO> toDTOs(List<Room> rooms){
        List<RoomDTO> output = new ArrayList<>();
        for (int i = 0; i < rooms.size(); i++) {
            output.add(RoomMapper.toDTO(rooms.get(i)));
        }
        return output;
    }

    public static List<Room> toRooms(List<RoomDTO> rooms){
        List<Room> output = new ArrayList<>();
        for (int i = 0; i < rooms.size(); i++) {
            output.add(RoomMapper.toRoom(rooms.get(i)));
        }
        return output;
    }

}
