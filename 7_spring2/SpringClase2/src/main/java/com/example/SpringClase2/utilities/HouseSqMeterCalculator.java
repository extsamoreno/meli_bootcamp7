package com.example.springclase2.utilities;

import com.example.springclase2.dto.House;
import com.example.springclase2.dto.Room;

import java.util.ArrayList;

public class HouseSqMeterCalculator {
    public static Double calculateSqMeters(House house)
    {
        Double meters = 0d;
        ArrayList<Room> rooms = house.getRooms();
        for (Room r :
                rooms) {
            meters += r.getArea();
        }
        return meters;
    }
}
