package com.example.ChallengeTwo.repository;

import com.example.ChallengeTwo.db.HousesDB;
import com.example.ChallengeTwo.model.House;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class HouseRepositoryImple implements IHouseRepository{

    HousesDB housesDB = new HousesDB();
    public final HashMap<String, House> dataBaseHouses = housesDB.getDataBaseHouses();

    @Override
    public House getHouseByName(String houseName) {
        return dataBaseHouses.get(houseName);
    }
}
