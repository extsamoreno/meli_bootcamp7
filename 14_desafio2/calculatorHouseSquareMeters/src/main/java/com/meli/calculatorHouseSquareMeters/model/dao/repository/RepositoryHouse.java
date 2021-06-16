package com.meli.calculatorHouseSquareMeters.model.dao.repository;

import com.meli.calculatorHouseSquareMeters.model.dao.model.House;

public interface RepositoryHouse {
    House getHouseByName(String name);
    public boolean putHouse(House house);
}
