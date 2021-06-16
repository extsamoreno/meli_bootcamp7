package com.example.desafio2.services.utils;

import com.example.desafio2.models.District;
import com.example.desafio2.models.Property;
import com.example.desafio2.models.Room;

public class PropertyUtil {
    public static double calculateArea(Property property){
        double sqMeters = 0;
        for (Room room : property.getRoomList()) {
            sqMeters += room.getLength() * room.getWidth();
        }
        return sqMeters;
    }

    public static double calculatePricePerSqMeter(District dist){
        return dist.getPrice();
    }
}
