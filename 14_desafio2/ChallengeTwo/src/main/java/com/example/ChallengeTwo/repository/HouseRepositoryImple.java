package com.example.ChallengeTwo.repository;

import com.example.ChallengeTwo.db.HousesDB;
import com.example.ChallengeTwo.dto.HouseDTO;
import com.example.ChallengeTwo.mapper.MapperHouse;
import com.example.ChallengeTwo.model.District;
import com.example.ChallengeTwo.model.House;
import lombok.Data;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
@Data
public class HouseRepositoryImple implements IHouseRepository{

    HousesDB housesDB = new HousesDB();
    public final HashMap<String, House> dataBaseHouses = housesDB.getDataBaseHouses();
    public final HashMap<String, District> dataBaseDistrics = housesDB.getDataBaseDistrics();

    @Override
    public House getHouseByName(String houseName) {
        if(dataBaseHouses.containsKey(houseName)){
            return dataBaseHouses.get(houseName);
        }
        else return null;
    }

    @Override
    public District getDistricByName(String districName) {
        return  dataBaseDistrics.get(districName);
    }

    @Override
    public Boolean addNewHouse(House houseAdd) {
        dataBaseHouses.put(houseAdd.getHouseName(),houseAdd);
        housesDB.addHouse(houseAdd);
        return true;
    }

    @Override
    public String addNewDistrict(District district) {
        dataBaseDistrics.put(district.getDistricName(),district);
        housesDB.addDistrict(district);
        return "Added district";
    }

    @Override
    public Boolean existsHouse(House house) {
        if(dataBaseHouses.containsKey(house.getHouseName())) return true;
        else return false;
    }

    @Override
    public Boolean existsDistrict(District district) {
        if(dataBaseDistrics.containsKey(district.getDistricName())) return true;
        else return false;
    }

}
