package com.example.ChallengeTwo.service;

import com.example.ChallengeTwo.dto.*;
import com.example.ChallengeTwo.exception.ProgramException;

import java.util.List;

public interface IHouseService {
    HouseTotalAreaDTO getTotalAreaHouse(String houseName) throws ProgramException;
    HouseTotalValueDTO getTotalValueHouse(String houseName) throws ProgramException;

    BiggerEnvironmentDTO getBiggerEnviroment(String houseName) throws ProgramException;

    List<EnvironmentAreaDTO> getAllEnviromentsArea(String houseName) throws ProgramException;

    String createNewHouse(HouseDTO house) throws ProgramException;


    String createNewDistrict(DistrictDTO districtDTO) throws ProgramException;
}
