package com.example.desafio2.util;

import com.example.desafio2.dtos.PropertyDTO;
import com.example.desafio2.dtos.RoomAreaDTO;
import com.example.desafio2.dtos.RoomDTO;
import com.example.desafio2.models.District;
import com.example.desafio2.models.Property;
import com.example.desafio2.models.Room;
import com.fasterxml.jackson.databind.ObjectWriter;

import java.util.ArrayList;
import java.util.List;

public class TestUtilsGenerator {
    private static String SCOPE;
    private static ObjectWriter mapper;

    public static Property getPropertyWith3Rooms(String name) {
        Room subject1 = new Room("Living", 5.0, 6.0);
        Room subject2 = new Room("Bedroom", 5.0, 3.0);
        Room subject3 = new Room("Kitchen", 4.0, 2.0);

        List<Room> roomList = new ArrayList<>();
        roomList.add(subject1);
        roomList.add(subject2);
        roomList.add(subject3);

        return new Property(name, 1, roomList);
    }

    public static PropertyDTO getPropertyDTOWith3Rooms(String name) {
        RoomDTO subject1 = new RoomDTO("Living", 5.0, 6.0);
        RoomDTO subject2 = new RoomDTO("Bedroom", 5.0, 3.0);
        RoomDTO subject3 = new RoomDTO("Kitchen", 4.0, 2.0);

        List<RoomDTO> roomList = new ArrayList<>();
        roomList.add(subject1);
        roomList.add(subject2);
        roomList.add(subject3);

        return new PropertyDTO(name, 1, roomList);
    }

    public static Property getPropertyWith3RoomsDetailed(String name, String room1Name, double room1Width, double room1Length, String room2Name, double room2Width, double room2Length, String room3Name, double room3Width, double room3Length) {
        Room subject1 = new Room(room1Name, room1Width, room1Length);
        Room subject2 = new Room(room2Name, room2Width, room2Length);
        Room subject3 = new Room(room3Name, room3Width, room3Length);

        List<Room> roomList = new ArrayList<>();
        roomList.add(subject1);
        roomList.add(subject2);
        roomList.add(subject3);

        return new Property(name, 1, roomList);
    }

    public static List<RoomAreaDTO> get3RoomAreasListDetailed(String room1Name, double area1, String room2Name, double area2, String room3Name, double area3) {
        List<RoomAreaDTO> roomAreaDTOList = new ArrayList<>();

        roomAreaDTOList.add(new RoomAreaDTO(room1Name,area1));
        roomAreaDTOList.add(new RoomAreaDTO(room2Name,area2));
        roomAreaDTOList.add(new RoomAreaDTO(room3Name,area3));

        return roomAreaDTOList;
    }

}
