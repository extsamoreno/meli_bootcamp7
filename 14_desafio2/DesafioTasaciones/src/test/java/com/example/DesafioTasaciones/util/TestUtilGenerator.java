package com.example.DesafioTasaciones.util;

import com.example.DesafioTasaciones.dtos.PropertyDTO;
import com.example.DesafioTasaciones.dtos.RoomDTO;
import com.example.DesafioTasaciones.models.District;
import com.example.DesafioTasaciones.models.Property;
import com.example.DesafioTasaciones.models.Room;

import java.util.ArrayList;
import java.util.List;

public class TestUtilGenerator {
    public static Property getProperty() {
        Room room1 = new Room("Habitacion 1",6.0,5.0);
        Room room2 = new Room("Habitacion 2",4.0,2.5);

        List<Room> rooms = new ArrayList<>();
        rooms.add(room1);
        rooms.add(room2);

        Property property = new Property();
        property.setName("Casa 1");
        property.setDistrict(new District("Capital",200.0));
        property.setRooms(rooms);
        return property;
    }

    public static PropertyDTO getPropertyDTO(String districtName) {
        RoomDTO room1 = new RoomDTO("Habitacion 1",6.0,5.0);
        RoomDTO room2 = new RoomDTO("Habitacion 2",4.0,2.5);

        List<RoomDTO> environments = new ArrayList<>();
        environments.add(room1);
        environments.add(room2);

        PropertyDTO house = new PropertyDTO();
        house.setName("Casa 1");
        house.setDistrictName(districtName);
        house.setRooms(environments);
        return house;
    }

    public static List<PropertyDTO> getPropertiesDTO() {
        PropertyDTO house1 = getPropertyDTO("D1");
        PropertyDTO house2 = getPropertyDTO("D2");
        PropertyDTO house3 = getPropertyDTO("D3");

        List<PropertyDTO> houses = new ArrayList<>();
        houses.add(house1);
        houses.add(house2);
        houses.add(house3);

        return houses;
    }

    public static List<Property> getProperties() {
        Property property1 = getProperty();
        Property property2 = getProperty();
        Property property3 = getProperty();

        List<Property> properties = new ArrayList<>();
        properties.add(property1);
        properties.add(property2);
        properties.add(property3);

        return properties;
    }
}
