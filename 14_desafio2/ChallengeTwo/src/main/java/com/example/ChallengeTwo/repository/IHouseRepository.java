package com.example.ChallengeTwo.repository;

import com.example.ChallengeTwo.dto.HouseDTO;
import com.example.ChallengeTwo.model.District;
import com.example.ChallengeTwo.model.House;

import java.util.List;

public interface IHouseRepository {
    House getHouseByName(String houseName);
    District getDistricByName(String districName);
    Boolean addNewHouse(House houseAdd);
    String addNewDistrict(District district);
    Boolean existsHouse(House house);
    Boolean existsDistrict(District district);
}
