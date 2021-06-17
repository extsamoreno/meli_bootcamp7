package com.bootcamp.desafio2.service;

import com.bootcamp.desafio2.dto.request.HouseDTO;
import com.bootcamp.desafio2.dto.response.EnvironmentShortDTO;
import com.bootcamp.desafio2.dto.response.HouseFeaturesDTO;
import com.bootcamp.desafio2.exception.district.DistrictNotFoundException;
import com.bootcamp.desafio2.exception.house.HouseAlreadyExistsException;
import com.bootcamp.desafio2.exception.house.HouseNotFoundException;

import java.util.ArrayList;

public interface IHouseService {

    HouseFeaturesDTO calculateFeatures(String prop_name) throws HouseNotFoundException, DistrictNotFoundException;

    ArrayList<EnvironmentShortDTO> generateEnvironmentList(String prop_name) throws HouseNotFoundException;

    void addNewProperty(HouseDTO houseDTO) throws DistrictNotFoundException, HouseAlreadyExistsException;
}
