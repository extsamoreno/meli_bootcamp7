package com.example.demo.repository;

import com.example.demo.exception.HouseNotFoundException;
import com.example.demo.models.District;
import com.example.demo.models.House;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IHouseRepository {
    void addHouse (House house);
    House findHouseByName (String name) throws HouseNotFoundException;
    List<House> getAllHouses ();
}
