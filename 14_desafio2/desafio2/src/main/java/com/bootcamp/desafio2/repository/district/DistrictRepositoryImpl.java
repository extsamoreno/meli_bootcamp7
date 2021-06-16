package com.bootcamp.desafio2.repository.district;

import com.bootcamp.desafio2.model.District;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

@Repository
public class DistrictRepositoryImpl implements IDistrictRepository{

    // Data Base of Districts
    private HashMap<String, Double> districtsDB = loadDateBase();


    // Method to Load the data to the DataBase
    private HashMap<String, Double> loadDateBase(){
        HashMap<String, Double> districtsDB = new HashMap<>();
        ArrayList<District> districtList = readDateBase();
        for(District x :  districtList){
            districtsDB.put(x.getDistrict_name(), x.getDistrict_price());
        }
        return districtsDB;
    }


    // Method to Read the data from JSON to List of Districts called districtList
    private ArrayList<District> readDateBase() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:districts.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper om = new ObjectMapper();
        TypeReference<ArrayList<District>> typeDef = new TypeReference<>() {
        };
        ArrayList<District> districtList = null;
        try {
            districtList = om.readValue(file, typeDef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return districtList;
    }

}
