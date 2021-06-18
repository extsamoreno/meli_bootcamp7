package com.example.desafio2.util;

import com.example.desafio2.model.Neighborhood;
import com.example.desafio2.model.Property;
import com.example.desafio2.model.Room;
import com.example.desafio2.service.DTO.NeighborhoodDTO;
import com.example.desafio2.service.DTO.PropertyDTO;
import com.example.desafio2.service.DTO.RoomDTO;

import java.util.LinkedList;
import java.util.List;

public class TestUtilsGenerator {
    public static PropertyDTO getPropertyDTOWith1Room(String neighborhoodName){
        List<RoomDTO> rooms = new LinkedList<>();
        rooms.add(new RoomDTO("Bedroom",1,1));
        return new PropertyDTO("Casa martin",new NeighborhoodDTO(neighborhoodName,10),rooms);
    }
    public static PropertyDTO getPropertyDTOWith1Room(String propName,String neighborhoodName){
        List<RoomDTO> rooms = new LinkedList<>();
        rooms.add(new RoomDTO("Bedroom",1,1));
        return new PropertyDTO(propName,new NeighborhoodDTO(neighborhoodName,10),rooms);
    }
    public static Property getPropertyWith3Room(String neighborhoodName){
        List<Room> rooms = new LinkedList<>();
        rooms.add(new Room("Bedroom",1,1));
        rooms.add(new Room("Kitchen",1,1));
        rooms.add(new Room("Bathroom",2,2));
        return new Property(neighborhoodName,new Neighborhood(neighborhoodName,10),rooms);
    }
    public static Property getPropertyWith1Room(String neighborhoodName){
        List<Room> rooms = new LinkedList<>();
        rooms.add(new Room("Bedroom",1,1));
        return new Property("Casa martin",new Neighborhood(neighborhoodName,10),rooms);
    }
}
