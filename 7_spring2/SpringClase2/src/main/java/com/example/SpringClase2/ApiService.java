package com.example.SpringClase2;

import java.time.LocalDate;
import java.time.Period;
import java.util.HashMap;

public class ApiService {

    public static HomeDTO getHouse(Home home) {

        HomeDTO homeDTO = new HomeDTO();

        float totalArea = home.totalArea();
        homeDTO.setTotalArea(totalArea);

        double totalPrice = home.totalPrice();
        homeDTO.setPrice(totalPrice);

        RoomDTO mainRoom = home.mainRoom();
        homeDTO.setMainRoom(mainRoom);

        HashMap<String, Float> metersPerRoom = home.metersPerRoom();
        homeDTO.setMetersPerRoom(metersPerRoom);
        return homeDTO;
    }

    public static int getAge(int year, int month, int day){
        LocalDate today = LocalDate.now();
        LocalDate bornday = LocalDate.of(year, month,day);
        Period diff = Period.between(bornday, today);
        return diff.getYears();
    }
}
