package com.meli.testingchallenge.repositories;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.testingchallenge.exceptions.ExistentDistrictNameException;
import com.meli.testingchallenge.models.District;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@Repository
@Setter
@Getter
@AllArgsConstructor
public class DistrictRepository implements IDistrictRepository{

    private List<District> districts;

    public DistrictRepository(){
        this.districts = loadDistrictsDB();
    }

    @Override
    public District findDistrictByName(String name) {
        return districts.stream()
                .filter(d->d.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void addDistrict(District district) throws ExistentDistrictNameException {

        District existent = findDistrictByName(district.getName());

        if (existent == null){
            districts.add(district);
        }else{
            throw new ExistentDistrictNameException(district.getName());
        }
    }

    private List<District> loadDistrictsDB() {
        File file = null;
        try{
            file = ResourceUtils.getFile("classpath:districts.json");
//            file = ResourceUtils.getFile("/Users/mstefanutti/workplace/meli_bootcamp7/14_desafio2/testingchallenge/src/main/resources/districts.json");
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }

        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<District>> typeRef = new TypeReference<>() {};

        List<District> db = null;

        try {
            db = objectMapper.readValue(file, typeRef);
        } catch (IOException e){
            e.printStackTrace();
        }
        return db;
    }
}
