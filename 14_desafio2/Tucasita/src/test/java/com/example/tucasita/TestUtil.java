package com.example.tucasita;

import com.example.tucasita.domain.Room;

import java.util.ArrayList;
import java.util.List;

public class TestUtil {

    public static List<Room> listOf3Rooms(String name, double num1, double num2) {
        List<Room> rooms = new ArrayList<>();
        rooms.add(new Room(name + " 1", num1, num1));
        rooms.add(new Room(name + " 2", num1, num2));
        rooms.add(new Room(name + " 3", num2, num2));
        return rooms;
    }
}
