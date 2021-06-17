package com.example.testingchallengev2.repository.district;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

@Repository
public class DistrictRepository implements IDistrictRepository{
    @Override
    public HashMap<String, Double> findAllDistricts() {
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
}
