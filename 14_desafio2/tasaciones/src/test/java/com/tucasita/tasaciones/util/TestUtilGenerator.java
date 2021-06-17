package com.tucasita.tasaciones.util;

import com.tucasita.tasaciones.dto.NeighborhoodDTO;
import com.tucasita.tasaciones.dto.PropertyDTO;
import com.tucasita.tasaciones.dto.RoomDTO;
import com.tucasita.tasaciones.model.Neighborhood;
import com.tucasita.tasaciones.model.Property;
import com.tucasita.tasaciones.model.Room;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.ResourceUtils;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class TestUtilGenerator {

    private static String SCOPE;

    public static void emptyPropertiesFile() {

        Properties properties = new Properties();

        PrintWriter writer = null;
        try {
            properties.load(new ClassPathResource("application.properties").getInputStream());
            SCOPE = properties.getProperty("api.scope");
            writer = new PrintWriter(ResourceUtils.getFile("./src/" + SCOPE + "/resources/properties.json"));
            writer.print("[]");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static PropertyDTO getPropertyDTOWithFourRooms() {
        NeighborhoodDTO neigh = new NeighborhoodDTO("La Plata", 400.0);
        RoomDTO room1 = new RoomDTO("Living room", 5, 4);
        RoomDTO room2 = new RoomDTO("Kitchen", 3.5, 2);
        RoomDTO room3 = new RoomDTO("Bathroom", 1.6, 3);
        RoomDTO room4 = new RoomDTO("Bedroom", 2.6, 3.7);
        List<RoomDTO> rooms = new ArrayList<>();
        rooms.add(room1);
        rooms.add(room2);
        rooms.add(room3);
        rooms.add(room4);
        PropertyDTO property = new PropertyDTO("home", neigh, rooms);
        return property;
    }

    public static Property getPropertyWithTwoRooms() {
        Neighborhood neigh = new Neighborhood("La Plata", 400.0);
        Room room1 = new Room("Living room", 5, 4);
        Room room2 = new Room("Bedroom", 5, 5);
        List<Room> rooms = new ArrayList<>();
        rooms.add(room1);
        rooms.add(room2);
        Property property = new Property(1, "home", neigh, rooms);
        return property;
    }
}
