package com.meli.desafio.unit;

import com.meli.desafio.utils.DataBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DataBaseTests {

    @Test
    public void loadDistricts(){
        DataBase db = new DataBase();

        db.loadDistricts();

        Assertions.assertTrue(DataBase.listDistricts.size() > 0);
    }

    @Test
    public void loadHouses(){
        DataBase db = new DataBase();

        db.loadHouses();

        Assertions.assertTrue(DataBase.listHouses.size() > 0);
    }
}
