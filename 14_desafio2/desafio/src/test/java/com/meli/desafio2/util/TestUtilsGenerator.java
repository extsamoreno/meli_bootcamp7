package com.meli.desafio2.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.desafio2.model.District;
import com.meli.desafio2.model.Property;
import com.meli.desafio2.model.Room;
import com.meli.desafio2.unit.service.dto.DistrictDTO;
import com.meli.desafio2.unit.service.dto.PropertyDTO;
import com.meli.desafio2.unit.service.dto.RoomDTO;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.*;

public class TestUtilsGenerator {

    private static String SCOPE;
    private static ObjectWriter mapper;

    private static double randomNumber() {
        Random random = new Random();
        return random.nextInt(23 - 1 + 1) + 1;
    }

    public static PropertyDTO getPropertyWith3Rooms(String name) {
        RoomDTO room1 = new RoomDTO("Matematica", randomNumber(), randomNumber());
        RoomDTO room2 = new RoomDTO("Lengua", randomNumber(), randomNumber());
        RoomDTO room3 = new RoomDTO("Fisica", randomNumber(), randomNumber());

        DistrictDTO districtDTO = new DistrictDTO("La Blanqueada", 420d);

        List<RoomDTO> rooms = new ArrayList<>();
        rooms.add(room1);
        rooms.add(room2);
        rooms.add(room3);

        PropertyDTO prop = new PropertyDTO();
        prop.setId(9999L);
        prop.setName(name);
        prop.setDistrict(districtDTO);
        prop.setRooms(rooms);

        return prop;
    }

    public static PropertyDTO getPropertyDTO(String name) {
        RoomDTO room1 = new RoomDTO("Matematica", 12d, 15d);
        RoomDTO room2 = new RoomDTO("Fatematica", 20d, 20d);
        RoomDTO room3 = new RoomDTO("Patematica", 10d, 10d);

        DistrictDTO districtDTO = new DistrictDTO("La Blanqueada", 420d);

        List<RoomDTO> rooms = new ArrayList<>();
        rooms.add(room1);
        rooms.add(room2);
        rooms.add(room3);

        PropertyDTO prop = new PropertyDTO();
        prop.setId(9999L);
        prop.setName(name);
        prop.setDistrict(districtDTO);
        prop.setRooms(rooms);

        return prop;
    }

    public static Property getProperty(String name) {
        Room room1 = new Room("Matematica", 12d, 15d);
        Room room2 = new Room("Fatematica", 20d, 20d);
        Room room3 = new Room("Patematica", 10d, 10d);
        District district = new District("La Blanqueada", 420d);

        List<Room> rooms = new ArrayList<>();
        rooms.add(room1);
        rooms.add(room2);
        rooms.add(room3);

        Property prop = new Property();
        prop.setId(9999L);
        prop.setName(name);
        prop.setDistrict(district);
        prop.setRooms(rooms);

        return prop;
    }


}
