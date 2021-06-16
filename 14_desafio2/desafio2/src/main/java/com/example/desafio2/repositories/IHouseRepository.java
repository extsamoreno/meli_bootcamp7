package com.example.desafio2.repositories;

import com.example.desafio2.models.House;

public interface IHouseRepository {
    void add(House house);
    House getHouseById(int houseId);
}
