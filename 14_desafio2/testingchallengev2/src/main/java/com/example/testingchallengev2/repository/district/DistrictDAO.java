package com.example.testingchallengev2.repository.district;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class DistrictDAO implements IDistrictDAO{

    @Autowired
    IDistrictRepository iDistrictRepository;

    private HashMap<String, Double> districts;

    @Override
    public double getPriceByName(String districtName) {
        updateDistrictRepository();
        return districts.get(districtName);
    }

    @Override
    public boolean findDistrictByName(String districtName) {
        updateDistrictRepository();
        return districts.containsKey(districtName);
    }

    @Override
    public void updateDistrictRepository() {
        districts = iDistrictRepository.findAllDistricts();
    }

    @Override
    public HashMap<String, Double> getDistricts() {
        updateDistrictRepository();
        return districts;
    }
}
