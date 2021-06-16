package com.example.desafio2.services.mappers;

import com.example.desafio2.dtos.RoomDTO;
import com.example.desafio2.models.Room;

import java.util.ArrayList;
import java.util.List;

public class RoomMapper {

    public static Room toModel(RoomDTO room){
        Room modelRoom = new Room();
        modelRoom.setLength(room.getLength());
        modelRoom.setName(room.getName());
        modelRoom.setWidth(room.getWidth());

        return modelRoom;
    }

    public static List<Room> toModelList(List<RoomDTO> roomList){

        Room modelRoom;
        List<Room> modelRoomList = new ArrayList<>();
        for (RoomDTO room : roomList) {
            modelRoom = new Room();
            modelRoom.setLength(room.getLength());
            modelRoom.setName(room.getName());
            modelRoom.setWidth(room.getWidth());

            modelRoomList.add(modelRoom);
        }

        return modelRoomList;
    }

    public static RoomDTO toDTO(Room room){
        RoomDTO roomDTO = new RoomDTO();

        roomDTO.setLength(room.getLength());
        roomDTO.setWidth(room.getWidth());
        roomDTO.setName(room.getName());

        return roomDTO;
    }
}
