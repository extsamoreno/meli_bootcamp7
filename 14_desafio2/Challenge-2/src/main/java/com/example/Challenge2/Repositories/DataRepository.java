package com.example.Challenge2.Repositories;

import com.example.Challenge2.Models.District;
import com.example.Challenge2.Models.Property;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@Repository
public class DataRepository implements IDataRepository{

    List<District> districts = this.loadDistricts();
    List<Property> properties = this.loadDProperties();


    @Override
    public District getDistrictById(Long id){
        for (int i = 0; i < this.districts.size(); i++) {
            if(this.districts.get(i).getId() == id){
                return this.districts.get(i);
            }
        }
        return null;
    }
    @Override
    public List<District> getAllDistricts() {
        return this.districts;
    }

    @Override
    public Property getPropertyById(Long id) {
        for (int i = 0; i < this.properties.size(); i++) {
            if(this.properties.get(i).getId().equals(id)){
                return this.properties.get(i);
            }
        }

        return null;
    }

    @Override
    public List<Property> getAllProperties() {
        return this.properties;
    }
    private List<Property> loadDProperties(){

        File file = null;
        try{
            file = ResourceUtils.getFile("classpath:properties.json");
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Property>> typeRef = new TypeReference<>() {};
        List<Property> properties = null;
        try{
            properties = objectMapper.readValue(file, typeRef);
        }
        catch(IOException e){
            e.printStackTrace();
        }

        return properties;
    }
    private List<District> loadDistricts(){

        File file = null;
        try{
            file = ResourceUtils.getFile("classpath:districts.json");
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<District>> typeRef = new TypeReference<>() {};
        List<District> districts = null;
        try{
            districts = objectMapper.readValue(file, typeRef);
        }
        catch(IOException e){
            e.printStackTrace();
        }

        return districts;
    }
}
