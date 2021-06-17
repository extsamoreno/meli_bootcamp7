package com.example.ChallengeTwo.repository;

import com.example.ChallengeTwo.db.HousesDB;
import com.example.ChallengeTwo.dto.HouseDTO;
import com.example.ChallengeTwo.mapper.MapperHouse;
import com.example.ChallengeTwo.model.District;
import com.example.ChallengeTwo.model.House;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class HouseRepositoryImple implements IHouseRepository{

    HousesDB housesDB = new HousesDB();
    public final HashMap<String, House> dataBaseHouses = housesDB.getDataBaseHouses();
    public final HashMap<String, District> dataBaseDistrics = housesDB.getDataBaseDistrics();

    @Override
    public House getHouseByName(String houseName) {
        return dataBaseHouses.get(houseName);
    }

    @Override
    public District getDistricByName(String districName) {
        return  dataBaseDistrics.get(districName);
    }

    @Override
    public String addNewHouse(House houseAdd) {
        dataBaseHouses.put(houseAdd.getHouseName(),houseAdd);
        housesDB.addHouse(houseAdd);
        return "Added house";
    }

    @Override
    public String addNewDistrict(District district) {
        dataBaseDistrics.put(district.getDistricName(),district);
        housesDB.addDistrict(district);
        return "Added district";
    }

}
