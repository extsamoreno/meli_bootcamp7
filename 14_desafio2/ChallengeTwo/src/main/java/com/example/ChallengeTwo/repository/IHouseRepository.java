package com.example.ChallengeTwo.repository;

import com.example.ChallengeTwo.dto.HouseDTO;
import com.example.ChallengeTwo.model.District;
import com.example.ChallengeTwo.model.House;

import java.util.List;

public interface IHouseRepository {
    House getHouseByName(String houseName);
    District getDistricByName(String districName);
    String addNewHouse(House houseAdd);
    String addNewDistrict(District district);
}
