package com.example.testingchallengev2.repository.house;

import com.example.testingchallengev2.exception.HouseNotFoundException;
import com.example.testingchallengev2.model.House;
import com.example.testingchallengev2.model.request.HouseDTO;

import java.util.HashMap;

public interface IHouseRepository {
    House getHouseByName(String houseName) throws HouseNotFoundException;
    boolean findHouseByName(String districtName);
    HashMap<String, House> getHouses();
    boolean createHouse(HouseDTO houseDTO);
}
