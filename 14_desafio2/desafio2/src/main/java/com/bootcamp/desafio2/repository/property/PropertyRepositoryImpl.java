package com.bootcamp.desafio2.repository.property;

import com.bootcamp.desafio2.model.Property;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

@Repository
public class PropertyRepositoryImpl implements IPropertyRepository{

    // Properties Data Base
    private HashMap<String, Property> propertiesDB = loadDateBase();


    // Method to Load the data to the DataBase
    public HashMap<String, Property> loadDateBase(){
        HashMap<String, Property> propertiesDB = new HashMap<>();
        ArrayList<Property> propertiesList = readDateBase();
        for(Property x : propertiesList){
            propertiesDB.put(x.getProp_name(), x);
        }
        return propertiesDB;
    }


    // Method to Read the data from JSON to List of properties called propertiesList
    public ArrayList<Property> readDateBase() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:properties.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper om = new ObjectMapper();
        TypeReference<ArrayList<Property>> typeDef = new TypeReference<>() {
        };
        ArrayList<Property> PropertiesList = null;
        try {
            PropertiesList = om.readValue(file, typeDef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return PropertiesList;
    }

}
