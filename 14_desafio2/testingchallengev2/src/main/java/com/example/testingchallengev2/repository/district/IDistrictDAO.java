package com.example.testingchallengev2.repository.district;

import com.example.testingchallengev2.exception.DistrictNotFoundException;

import java.util.HashMap;

public interface IDistrictDAO {
    double getPriceByName(String districtName) throws DistrictNotFoundException;
    boolean findDistrictByName(String districtName);
    void updateDistrictRepository();

    HashMap<String, Double> getDistricts();
}
