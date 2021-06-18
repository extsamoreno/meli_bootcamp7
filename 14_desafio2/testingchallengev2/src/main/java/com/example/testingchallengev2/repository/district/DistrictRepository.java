package com.example.testingchallengev2.repository.district;

import com.example.testingchallengev2.exception.DistrictNotFoundException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class DistrictRepository implements IDistrictRepository {

    //@Autowired
    //IDistrictLoader iDistrictLoader;

    private HashMap<String, Double> districts = findAllDistricts();

    private HashMap<String, Double> findAllDistricts() {
        HashMap<String, Double> loadedData = new HashMap<>();

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            File file = ResourceUtils.getFile("classpath:districts.json");
            loadedData = objectMapper.readValue(file, new TypeReference<HashMap<String, Double>>(){});
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Failed while initializing DB, check your resources files");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed while initializing DB, check your JSON formatting.");
        }

        return loadedData;
    }

    @Override
    public double getPriceByName(String districtName) throws DistrictNotFoundException {
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
        return districts.containsKey(districtName);
    }


    @Override
    public HashMap<String, Double> getDistricts() {
        return districts;
    }

    @Override
    public boolean createDistrict(String name, double price) {
        boolean creationResult = false;
        if(!findDistrictByName(name))
        {
            districts.put(name, price);
            creationResult = true;
        }
        return creationResult;
    }

    @Override
    public boolean updateDistrict(String name, double price) {
        boolean result = false;
        if(findDistrictByName(name))
        {
            districts.put(name, price);
            result = true;
        }
        return result;
    }
}
