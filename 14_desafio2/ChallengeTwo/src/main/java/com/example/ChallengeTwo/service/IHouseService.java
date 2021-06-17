package com.example.ChallengeTwo.service;

import com.example.ChallengeTwo.dto.*;

import java.util.List;

public interface IHouseService {
    HouseTotalAreaDTO getTotalAreaHouse(String houseName);
    HouseTotalValueDTO getTotalValueHouse(String houseName);

    BiggerEnvironmentDTO getBiggerEnviroment(String houseName);

    List<EnvironmentAreaDTO> getAllEnviromentsArea(String houseName);

    String createNewHouse(HouseDTO house);


    String createNewDistrict(DistrictDTO districtDTO);
}
