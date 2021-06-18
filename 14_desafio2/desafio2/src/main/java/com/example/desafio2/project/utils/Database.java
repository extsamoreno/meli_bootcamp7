package com.example.desafio2.project.utils;

import com.example.desafio2.project.models.District;
import com.example.desafio2.project.models.Property;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class Database {
    public static List<Property> listProperties = new ArrayList<>(); //List of properties
    public static List<District> listDistricts = new ArrayList<>(); //List of districts

    public void loadPropertiesDataBase() {
        File file = null;

        try {
            file = ResourceUtils.getFile("classpath:property.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Property>> typeRef = new TypeReference<>() {};
        List<Property> list = null;

        try{
            list = objectMapper.readValue(file , typeRef);
        }catch (IOException e){
            e.printStackTrace();
        }

        for(Property p: list){
            listProperties.add(p);
        }
    }

    public void loadDistrictsDataBase() {
        File file = null;

        try {
            file = ResourceUtils.getFile("classpath:districts.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<District>> typeRef = new TypeReference<>() {};
        List<District> list = null;

        try{
            list = objectMapper.readValue(file , typeRef);
        }catch (IOException e){
            e.printStackTrace();
        }

        for(District d: list){
            listDistricts.add(d);
        }
    }
    


}
