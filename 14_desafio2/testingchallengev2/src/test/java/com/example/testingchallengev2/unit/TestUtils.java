package com.example.testingchallengev2.unit;

import com.example.testingchallengev2.model.House;
import com.example.testingchallengev2.model.Room;

import java.util.ArrayList;

public class TestUtils {
    public static House getHouseWithName(String name)
    {
        Room room1 = new Room("baño", 2.0, 2.0);
        ArrayList<Room> rooms = new ArrayList<>();
        rooms.add(room1);
        String dist = "Centro";
        return new House(name, dist, rooms);
    }
}
