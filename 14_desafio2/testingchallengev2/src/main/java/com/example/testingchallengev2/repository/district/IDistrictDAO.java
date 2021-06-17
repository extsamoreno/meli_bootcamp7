package com.example.testingchallengev2.repository.district;

import java.util.HashMap;

public interface IDistrictDAO {
    double getPriceByName(String districtName);
    boolean findDistrictByName(String districtName);
    void updateDistrictRepository();

    HashMap<String, Double> getDistricts();
}
