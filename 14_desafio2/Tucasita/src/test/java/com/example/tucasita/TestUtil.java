package com.example.tucasita;

import com.example.tucasita.domain.Room;
import com.example.tucasita.dto.DistrictDTO;
import com.example.tucasita.dto.HouseDTO;
import com.example.tucasita.dto.RoomDTO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestUtil {

    public static List<Room> listOf3Rooms(String name, double num1, double num2) {
        List<Room> rooms = new ArrayList<>();
        rooms.add(new Room(name + " 1", num1, num1));
        rooms.add(new Room(name + " 2", num1, num2));
        rooms.add(new Room(name + " 3", num2, num2));
        return rooms;
    }

    public static HouseDTO getSampleHouseDTO() {
        DistrictDTO districtDTO = new DistrictDTO("Barrio", 100D);
        RoomDTO roomDTO1 = new RoomDTO("room1", 10D, 2D);
        RoomDTO roomDTO2 = new RoomDTO("room2", 20D, 3D);
        List<RoomDTO> roomsDTO = Arrays.asList(roomDTO1, roomDTO2);
        return new HouseDTO("Casa", districtDTO, roomsDTO);
    }
}
