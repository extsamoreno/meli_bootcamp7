package com.meli.desafio2.web.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.desafio2.web.model.District;
import com.meli.desafio2.web.model.Property;
import lombok.Data;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
@Repository
@Data

public class DistrictRepository implements IDistrictRepository {

    private List<District> districts = loadDataDistrict();
    private List<District> loadDataDistrict() {
        File file = null;
        try{
            file = ResourceUtils.getFile("classpath:district.json");
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<District>> typeRef = new TypeReference<>() {};
        List<District> districts = null;

        try {
            districts = objectMapper.readValue(file,typeRef);
        } catch (IOException e){
            e.printStackTrace();
        }
        return districts;

    }
    @Override
    public District getDistrictByName(String name){
        for(District district:districts){
            if(district.getDistrict_name().equals(name)){
                return district;
            }
        }
        return null;
    }

    @Override
    public void saveDistrict(District district) {
        districts.add(district);
    }
}
