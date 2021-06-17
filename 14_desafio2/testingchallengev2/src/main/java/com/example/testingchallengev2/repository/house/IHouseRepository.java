package com.example.testingchallengev2.repository.house;

import com.example.testingchallengev2.model.House;

import java.util.HashMap;

public interface IHouseRepository {
    HashMap<String, House> findAllHouse();
}
