package com.example.testingchallengev2.repository.house;

import com.example.testingchallengev2.exception.HouseNotFoundException;
import com.example.testingchallengev2.model.House;

import java.util.HashMap;

public interface IHouseDAO {
    House getHouseByName(String houseName) throws HouseNotFoundException;
    boolean findHouseByName(String districtName);
    void updateHouseRepository();

    HashMap<String, House> getHouses();
}
