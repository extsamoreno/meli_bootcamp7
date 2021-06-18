package com.tuCasita.tuCasita.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tuCasita.tuCasita.exceptions.DeserializeJsonException;
import com.tuCasita.tuCasita.exceptions.DistrictNotFoundError;
import com.tuCasita.tuCasita.exceptions.FileOpenException;
import com.tuCasita.tuCasita.models.District;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class DistrictRepository implements iDistrictRepository{

    HashMap<String, Double> districts;

    public DistrictRepository(){
        this.districts = loadDistricts();
    }

    @Override
    public List<District> loadDataBase() {
        List<District> districts = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            File file = ResourceUtils.getFile("classpath:districts.json");
            districts = objectMapper.readValue(file, new TypeReference<>() {});
        } catch (FileNotFoundException e) {
            throw new FileOpenException();
        } catch(IOException e) {
            throw new DeserializeJsonException();
        }
        return districts;
    }

    @Override
    public HashMap<String, Double> loadDistricts(){
        this.districts = new HashMap<>();
        loadDataBase().stream().forEach(district -> {
            this.districts.put(district.getName(), district.getPrice());
        });
        return this.districts;
    }

    @Override
    public HashMap<String, Double> getDistricts() {
        return this.districts;
    }

}
