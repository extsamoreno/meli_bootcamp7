package com.meli.desafio2.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.desafio2.model.District;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Repository
public class DistrictRepositoryImpl implements DistrictRepository{
    private final List<District> districts;

    public DistrictRepositoryImpl() {
        this.districts = loadDatabase();
    }

    public District findDistrictByID(int district_id){
        District district = null;

        if(this.districts != null){
            District item = this.districts.stream()
                    .filter(district1 -> district_id == district1.getId())
                    .findFirst()
                    .orElse(null);

            if(item != null){
                district = item;
            }
        }

        return district;
    }

    private List<District> loadDatabase() {
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
        } catch (IOException e) {
            e.printStackTrace();
        }

        return districts;
    }
}
