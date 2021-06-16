package com.example.ChallengeTwo.service;

import com.example.ChallengeTwo.dto.BiggerEnvironmentDTO;
import com.example.ChallengeTwo.dto.EnvironmentAreaDTO;
import com.example.ChallengeTwo.dto.HouseTotalAreaDTO;
import com.example.ChallengeTwo.dto.HouseTotalValueDTO;

import java.util.List;

public interface IHouseService {
    HouseTotalAreaDTO getTotalAreaHouse(String houseName);
    HouseTotalValueDTO getTotalValueHouse(String houseName);

    BiggerEnvironmentDTO getBiggerEnviroment(String houseName);

    List<EnvironmentAreaDTO> getAllEnviromentsArea(String houseName);
}
