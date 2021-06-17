package com.example.Challenge2.util;

import com.example.Challenge2.Models.District;
import com.example.Challenge2.Models.Property;
import com.example.Challenge2.Models.Room;
import com.example.Challenge2.Services.DTOs.PropertyDTO;
import com.example.Challenge2.Services.DTOs.RoomDTO;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.ResourceUtils;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class TestUtilsGenerator {

    private static String SCOPE;
    private static ObjectWriter mapper;

    public static void emptyUsersFile() {
        Properties properties = new Properties();

        try {
            properties.load(new ClassPathResource("application.properties").getInputStream());
            SCOPE = properties.getProperty("api.scope");
        } catch (IOException e) {
            e.printStackTrace();
        }

        PrintWriter writer = null;

        try {
            writer = new PrintWriter(ResourceUtils.getFile("./src/" + SCOPE + "/resources/users.json"));
        } catch (
                IOException e) {
            e.printStackTrace();
        }

        writer.print("[]");
        writer.close();
    }

    public static Property getPropertyWith3Rooms(Long id) {
        Room room1 = new Room("Cocina", 8.0, 3.0);
        Room room2 = new Room("Living",3.0, 6.0);
        Room room3 = new Room("Dormitorio",2.0, 4.0);

        List<Room> rooms = new ArrayList<>();
        rooms.add(room1);
        rooms.add(room2);
        rooms.add(room3);

        Property property = new Property();
        property.setName("House");
        property.setDistrictId(id);
        property.setRooms(rooms);

        return property;
    }
    public static District get100USDollarsDistrict(Long id) {

        District district = new District(id,"District",100.0);

        return district;
    }
    public static Property get50MtProperty(Long id) {
        Room room1 = new Room("Cocina", 8.0, 3.0);
        Room room2 = new Room("Living",3.0, 6.0);
        Room room3 = new Room("Dormitorio",2.0, 4.0);

        List<Room> rooms = new ArrayList<>();
        rooms.add(room1);
        rooms.add(room2);
        rooms.add(room3);

        Property property = new Property();
        property.setName("House");
        property.setId(id);
        property.setRooms(rooms);

        return property;
    }

    public static Property getPropertyWith100M2BiggestRoom(Long id) {
        Room room1 = new Room("Cocina", 8.0, 3.0);
        Room room2 = new Room("Living",3.0, 6.0);
        Room room3 = new Room("Dormitorio",10.0, 10.0);

        List<Room> rooms = new ArrayList<>();
        rooms.add(room1);
        rooms.add(room2);
        rooms.add(room3);

        Property property = new Property();
        property.setName("House");
        property.setId(id);
        property.setRooms(rooms);

        return property;
    }
    public static Property getPropertyWith50M2BiggestRoom(Long id) {
        Room room1 = new Room("Cocina", 8.0, 3.0);
        Room room2 = new Room("Living",3.0, 6.0);
        Room room3 = new Room("Dormitorio",10.0, 5.0);

        List<Room> rooms = new ArrayList<>();
        rooms.add(room1);
        rooms.add(room2);
        rooms.add(room3);

        Property property = new Property();
        property.setName("House");
        property.setId(id);
        property.setRooms(rooms);

        return property;
    }


    public static List<Room> getTwo25Mt2Rooms() {
        Room room1 = new Room("Cocina", 5.0, 5.0);
        Room room2 = new Room("Living",5.0, 5.0);

        List<Room> rooms = new ArrayList<>();
        rooms.add(room1);
        rooms.add(room2);

        return rooms;
    }

}
