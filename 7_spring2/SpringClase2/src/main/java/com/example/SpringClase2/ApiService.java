package com.example.SpringClase2;

import java.time.LocalDate;
import java.time.Period;
import java.util.HashMap;

public class ApiService {

    public static HomeDTO getHouse(House house) {

        HomeDTO homeDTO = new HomeDTO();

        float totalArea = house.totalArea();
        homeDTO.setTotalArea(totalArea);

        double totalPrice = house.totalPrice();
        homeDTO.setPrice(totalPrice);

        RoomDTO mainRoom = house.mainRoom();
        homeDTO.setMainRoom(mainRoom);

        homeDTO.setMetersPerRoom(house.meterPerRoom());
        return homeDTO;
    }

    public static int getAge(int year, int month, int day){
        LocalDate today = LocalDate.now();
        LocalDate bornday = LocalDate.of(year, month,day);
        Period diff = Period.between(bornday, today);
        return diff.getYears();
    }

    public static Degreed degreed(Student student){
        return student.degreed();
    }
}
