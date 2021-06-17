package com.example.testingchallengev2.repository.district;

import com.example.testingchallengev2.exception.DistrictNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class DistrictDAO implements IDistrictDAO{

    @Autowired
    IDistrictRepository iDistrictRepository;

    private HashMap<String, Double> districts;

    @Override
    public double getPriceByName(String districtName) throws DistrictNotFoundException {
        updateDistrictRepository();
        if(findDistrictByName(districtName))
        {
            return districts.get(districtName);
        }
        else
        {
            throw new DistrictNotFoundException();
        }
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
