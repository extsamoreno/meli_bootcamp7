package com.example.ChallengeTwo.service;

import com.example.ChallengeTwo.dto.HouseTotalAreaDTO;
import com.example.ChallengeTwo.dto.HouseTotalValueDTO;

public interface IHouseService {
    HouseTotalAreaDTO getTotalAreaHouse(String houseName);

    HouseTotalValueDTO getTotalValueHouse(String houseName);
}
