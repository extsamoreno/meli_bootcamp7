package com.meli.tucasita.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.tucasita.models.Property;
import lombok.Data;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@Repository
@Data
public class PropertyRepositoryImpl implements IPropertyRepository{

    public static Set<Property> properties = new HashSet<>();

    public PropertyRepositoryImpl(){
        loadData();
    }

    public boolean propertyAlreadyExists(String name){
       return properties.stream().anyMatch(prop -> name.equals(prop.getName()));
    }

    public void insertNewProperty(Property property){
        properties.add(property);
    }

    public void loadData() {

        Set<Property> loadedDataFromJson = new HashSet<>();

        ObjectMapper objectMapper = new ObjectMapper();
        File file;
        try {
            file = ResourceUtils.getFile("classpath:properties_database.json");
            loadedDataFromJson = objectMapper.readValue(file, new TypeReference<>(){});
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Failed while initializing DB, check your resources files");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed while initializing DB, check your JSON formatting.");
        }
        properties = loadedDataFromJson;
    }

    public void saveDataIntoJson() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            File file = ResourceUtils.getFile("classpath:properties_database.json");
            objectMapper.writeValue(file, properties);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Failed while writing to DB, check your resources files");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed while writing to DB, check your JSON formatting.");
        }
    }
}

