package com.example.demo.service;

import com.example.demo.exception.DistrictNotFoundException;
import com.example.demo.exception.ExistingDistrictException;
import com.example.demo.exception.ExistingHouseException;
import com.example.demo.exception.HouseNotFoundException;
import com.example.demo.models.District;
import com.example.demo.models.Environment;
import com.example.demo.models.House;
import com.example.demo.service.dto.*;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
@Service
public interface IHouseService {

    double calculateM2(String name) throws HouseNotFoundException, DistrictNotFoundException;
    double calculateM2Environment(Environment environment);
    double calculatePrice(String name) throws HouseNotFoundException, DistrictNotFoundException;
    String biggestEnvironment(String name) throws HouseNotFoundException, DistrictNotFoundException;
    ArrayList<String> environmentM2 (String name) throws HouseNotFoundException;
    void addHouse (HouseDTO houseDTO) throws DistrictNotFoundException, ExistingHouseException;
    void addDistrict (DistrictDTO districtDTO) throws DistrictNotFoundException, ExistingDistrictException;
    ResponseHouseDTO calculateAllRequirements (String name) throws HouseNotFoundException, DistrictNotFoundException;
    HouseM2DTO getM2 (String name) throws HouseNotFoundException, DistrictNotFoundException;
    HousePriceDTO getPrice (String name) throws HouseNotFoundException, DistrictNotFoundException;
    HouseBiggestEnvironmentDTO getBiggestEnvironment (String name) throws HouseNotFoundException, DistrictNotFoundException;
    HouseListEnvironmentDTO getListEnvironmentWhitM2 (String name) throws HouseNotFoundException;
}
