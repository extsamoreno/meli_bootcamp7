package com.example.demo.service;

import com.example.demo.exception.DistrictNotFoundException;
import com.example.demo.exception.HouseNotFoundException;
import com.example.demo.models.District;
import com.example.demo.models.Environment;
import com.example.demo.models.House;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
@Service
public interface IHouseService {

    double calculateM2(String name) throws HouseNotFoundException, DistrictNotFoundException;
    double calculateM2Environment(Environment environment);
    double calculatePrice(String name) throws HouseNotFoundException, DistrictNotFoundException;
    String biggestEnvironment(String name) throws HouseNotFoundException, DistrictNotFoundException;
    ArrayList<String> environmentM2 (String name) throws HouseNotFoundException;
    void addHouse (House house) throws DistrictNotFoundException;
    void addDistrict (District district) throws DistrictNotFoundException;
}
