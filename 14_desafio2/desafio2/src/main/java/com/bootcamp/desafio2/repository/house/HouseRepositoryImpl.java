package com.bootcamp.desafio2.repository.house;

import com.bootcamp.desafio2.exception.house.HouseNotFoundException;
import com.bootcamp.desafio2.entity.House;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

@Repository
@NoArgsConstructor
public class HouseRepositoryImpl implements IHouseRepository {

    // Properties Data Base
    private HashMap<String, House> propertiesDB = loadDateBase();


    // Method to Load the data to the DataBase
    public HashMap<String, House> loadDateBase(){
        HashMap<String, House> propertiesDB = new HashMap<>();
        ArrayList<House> propertiesList = readDateBase();
        for(House x : propertiesList){
            propertiesDB.put(x.getProp_name(), x);
        }
        return propertiesDB;
    }


    // Method to Read the data from JSON to List of properties called propertiesList
    public ArrayList<House> readDateBase() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:properties.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper om = new ObjectMapper();
        TypeReference<ArrayList<House>> typeDef = new TypeReference<>() {
        };
        ArrayList<House> PropertiesList = null;
        try {
            PropertiesList = om.readValue(file, typeDef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return PropertiesList;
    }

    @Override
    public boolean existsPropertyName(String prop_name) {
        boolean exists = false;
        if ( propertiesDB.containsKey(prop_name))
            exists = true;
        return exists;
    }

    @Override
    public House findHouseByPropName(String prop_name) {
        return propertiesDB.getOrDefault(prop_name, null);
    }

    @Override
    public void saveNewProperty(House house) {
        propertiesDB.put(house.getProp_name(), house);
    }
}
