package com.meli.calculatorHouseSquareMeters.model.dao.repository;

import com.meli.calculatorHouseSquareMeters.database.DataBaseHouses;
import com.meli.calculatorHouseSquareMeters.model.dao.model.House;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class RepositoryHouseImpl implements RepositoryHouse{
    private final ArrayList<House> dataBaseHouses = DataBaseHouses.dataBaseHouses;

    public House getHouseByName(String name) {
        House house = null;
        for (House house_: dataBaseHouses) {
            if (house_.getHouseName().equals(name)) {
                house = house_;
                break;
            }
        }
        return house;
    }

    public boolean putHouse(House house) {
        if (!houseExist(house.getHouseName())) {
            dataBaseHouses.add(house);
            return true;
        }
        return false;
    }

    private boolean houseExist(String name) {
        boolean exist = false;
        for (House house: dataBaseHouses) {
            if (house.getHouseName().equals(name)) {
                exist = true;
                break;
            }
        }
        return exist;
    }
}
