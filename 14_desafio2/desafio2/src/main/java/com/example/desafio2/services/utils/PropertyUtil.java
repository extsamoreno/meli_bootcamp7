package com.example.desafio2.services.utils;

import com.example.desafio2.models.District;
import com.example.desafio2.models.Property;
import com.example.desafio2.models.Room;
import com.example.desafio2.repositories.IDistrictRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class PropertyUtil {
    public static double getArea(Property property){
        double sqMeters = 0;
        for (Room room : property.getRoomList()) {
            sqMeters += room.getLength() * room.getWidth();
        }
        return sqMeters;
    }
}
