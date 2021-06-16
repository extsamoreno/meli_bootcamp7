package com.meli.calculatorHouseSquareMeters.database;

import com.meli.calculatorHouseSquareMeters.model.dao.model.District;

import java.util.ArrayList;
import java.util.Arrays;

public class DataBaseDistricts {
    public static ArrayList<District> dataBaseDistricts = new ArrayList<>(
            Arrays.asList(new District("Barrio Bajo", 800),
                    new District("Bario Medio Bajo", 1600),
                    new District("Barrio Medio", 2400),
                    new District("Barrio Medio Alto", 3200),
                    new District("Barrio Alto", 4000)
                    ));
}
