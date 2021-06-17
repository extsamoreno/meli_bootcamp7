package com.example.testingchallengev2.repository.house;

import com.example.testingchallengev2.model.House;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class HouseDAO implements IHouseDAO{

    @Autowired
    IHouseRepository iHouseRepository;

    private HashMap<String, House> houses;


    @Override
    public House getHouseByName(String houseName) {
        updateHouseRepository();
        return houses.get(houseName);
    }

    @Override
    public boolean findHouseByName(String houseName) {
        updateHouseRepository();
        return houses.containsKey(houseName);
    }

    @Override
    public void updateHouseRepository() {
        houses = iHouseRepository.findAllHouse();
    }

    @Override
    public HashMap<String, House> getHouses() {
        updateHouseRepository();
        return houses;
    }
}
