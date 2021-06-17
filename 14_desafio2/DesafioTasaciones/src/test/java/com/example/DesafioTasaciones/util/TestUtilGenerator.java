package com.example.DesafioTasaciones.util;

import com.example.DesafioTasaciones.dtos.HouseDTO;
import com.example.DesafioTasaciones.dtos.RoomDTO;
import com.example.DesafioTasaciones.models.District;
import com.example.DesafioTasaciones.models.House;
import com.example.DesafioTasaciones.models.Room;

import java.util.ArrayList;
import java.util.List;

public class TestUtilGenerator {
    public static House getProperty() {
        Room room1 = new Room("Habitacion 1",6.0,5.0);
        Room room2 = new Room("Habitacion 2",4.0,2.5);

        List<Room> rooms = new ArrayList<>();
        rooms.add(room1);
        rooms.add(room2);

        House house = new House();
        house.setName("Casa 1");
        house.setDistrict(new District("Capital",200.0));
        house.setRooms(rooms);
        return house;
    }

    public static HouseDTO getPropertyDTO(String districtName) {
        RoomDTO room1 = new RoomDTO("Habitacion 1",6.0,5.0);
        RoomDTO room2 = new RoomDTO("Habitacion 2",4.0,2.5);

        List<RoomDTO> environments = new ArrayList<>();
        environments.add(room1);
        environments.add(room2);

        HouseDTO house = new HouseDTO();
        house.setName("Casa 1");
        house.setDistrictName(districtName);
        house.setRooms(environments);
        return house;
    }

    public static List<HouseDTO> getPropertiesDTO() {
        HouseDTO house1 = getPropertyDTO("D1");
        HouseDTO house2 = getPropertyDTO("D2");
        HouseDTO house3 = getPropertyDTO("D3");

        List<HouseDTO> houses = new ArrayList<>();
        houses.add(house1);
        houses.add(house2);
        houses.add(house3);

        return houses;
    }

    public static List<House> getProperties() {
        House house1 = getProperty();
        House house2 = getProperty();
        House house3 = getProperty();

        List<House> houses = new ArrayList<>();
        houses.add(house1);
        houses.add(house2);
        houses.add(house3);

        return houses;
    }
}
