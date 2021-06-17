package com.example.demo.repository;

import com.example.demo.models.District;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Repository
public class DistrictRepository implements IDistrictRepository {


    @Override
    public District findDistrictByName(String name) {
        List<District> districtList = null;
        districtList = loadDatabase();
        District result = null;
        if (districtList!=null){
            Optional<District> item = districtList.stream().filter(district -> district.getDistric_name().equals(name)).findFirst();
            if (item.isPresent()){
                result = item.get();
            }
        }
        return result;

    }
    private List<District> loadDatabase() {
        File file = null;
        try {
            file = ResourceUtils.getFile("src/main/resources/static/district.json");
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<District>> typeReference = new TypeReference<>() {};
        List<District> publications = null;
        try {
            publications =  objectMapper.readValue(file,typeReference);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return publications;

    }
}
