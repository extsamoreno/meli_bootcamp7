package com.meli.calculatorHouseSquareMeters.database;

import com.meli.calculatorHouseSquareMeters.model.dao.model.District;
import com.meli.calculatorHouseSquareMeters.model.dao.model.House;
import com.meli.calculatorHouseSquareMeters.model.dao.model.Room;

import java.util.ArrayList;
import java.util.Arrays;

public class DataBaseHouses {
    public static ArrayList<House> dataBaseHouses = new ArrayList<>(Arrays.asList(new House(
            "Casa1",
            new District("Barrio Bajo",800),
            1,
            100,
            80000, new ArrayList<Room>(Arrays.asList(new Room("Habitación 1", 10, 10))))));
}
