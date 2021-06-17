package com.meli.calculatorHouseSquareMeters.model.dao.repository;

import com.meli.calculatorHouseSquareMeters.database.DataBaseHouses;
import com.meli.calculatorHouseSquareMeters.model.dao.model.District;
import com.meli.calculatorHouseSquareMeters.model.dao.model.House;
import com.meli.calculatorHouseSquareMeters.model.dao.model.Room;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;

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

    public void resetDataBase() {
        House house = new House("Casa1", new District("Barrio Bajo",
                800),
                1,
                100,
                80000, new ArrayList<Room>(Arrays.asList(new Room("Habitación 1", 10, 10))));
        dataBaseHouses.clear();
        dataBaseHouses.add(house);
    }
}
