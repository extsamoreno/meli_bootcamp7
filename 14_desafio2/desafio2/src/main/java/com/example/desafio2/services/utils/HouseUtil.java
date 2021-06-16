package com.example.desafio2.services.utils;

import com.example.desafio2.models.District;
import com.example.desafio2.models.House;
import com.example.desafio2.models.Room;

public class HouseUtil {
    public static double calculateArea(House house){
        double sqMeters = 0;
        for (Room room : house.getRoomList()) {
            sqMeters += room.getLength() * room.getWidth();
        }
        return sqMeters;
    }

    public static double calculatePricePerSqMeter(District dist){
        return dist.getPrice();
    }
}
