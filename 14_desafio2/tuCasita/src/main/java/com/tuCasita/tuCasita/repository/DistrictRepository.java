package com.tuCasita.tuCasita.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tuCasita.tuCasita.exceptions.DistrictNotFoundError;
import com.tuCasita.tuCasita.models.District;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class DistrictRepository implements iDistrictRepository{

    HashMap<String, Double> districts;

    @Override
    public List<District> loadDataBase() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:districts.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<District>> typeRef = new TypeReference<>() {};
        List<District> districts = null;

        try {
            districts = objectMapper.readValue(file, typeRef);
        } catch(IOException e) {
            e.printStackTrace();
        }
        return districts;
    }

    @Override
    public void loadDistricts(){
        loadDataBase().stream().forEach(district -> {
            this.districts.put(district.getName(), district.getPrice());
        });
    }

    @Override
    public HashMap<String, Double> getDistricts() {
        try {
            return this.districts;
        } catch (Exception e){
            throw new DistrictNotFoundError("El barrio requerido no existe", HttpStatus.NOT_FOUND);
        }
    }

}
