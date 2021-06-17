package com.example.demo.repositories;


import com.example.demo.entities.District;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@Repository
public class DistrictRepository  implements IDistrictRepository {

    String districtPathFile = System.getProperty("user.dir") + "/src/main/resources/data/District.json";

    List<District> districts = loadDistrict();

    @Override
    public List<District> loadDistrict() {
        File file = null;
        try {
            file = ResourceUtils.getFile(districtPathFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<District>> typeRef = new TypeReference<>() {
        };
        List<District> districts = null;
        try {
            districts = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return districts;
    }

    @Override
    public void saveDistrict() {
        File file = null;
        try {
            file = ResourceUtils.getFile(districtPathFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            objectMapper.writeValue(file, districts);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
