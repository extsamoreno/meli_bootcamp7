package com.example.SpringClase2;

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
}
