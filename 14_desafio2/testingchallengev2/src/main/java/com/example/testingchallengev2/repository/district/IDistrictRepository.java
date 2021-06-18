package com.example.testingchallengev2.repository.district;

import com.example.testingchallengev2.exception.DistrictNotFoundException;

import java.util.HashMap;

public interface IDistrictRepository {
    double getPriceByName(String districtName) throws DistrictNotFoundException;
    boolean findDistrictByName(String districtName);
    HashMap<String, Double> getDistricts();
    boolean createDistrict(String name, double price);
    boolean updateDistrict(String name, double price);
}
