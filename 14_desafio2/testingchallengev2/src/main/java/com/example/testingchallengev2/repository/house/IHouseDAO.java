package com.example.testingchallengev2.repository.house;

import com.example.testingchallengev2.model.House;

import java.util.HashMap;

public interface IHouseDAO {
    House getHouseByName(String houseName);
    boolean findHouseByName(String districtName);
    void updateHouseRepository();

    HashMap<String, House> getHouses();
}
