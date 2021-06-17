package com.example.demo.repositories;

import com.example.demo.DTO.ResponseCalculateTotalMetersDTO;
import com.example.demo.entities.District;
import com.example.demo.entities.Environment;
import com.example.demo.entities.Property;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@Repository
public class PropertyRepository implements IPropertyRepository {

    String propertyPathFile = System.getProperty("user.dir") + "/src/main/resources/data/Property.json";

    List<Property> properties = loadProperties();

    @Override
    public List<Property> loadProperties() {
        File file = null;
        try {
            file = ResourceUtils.getFile(propertyPathFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Property>> typeRef = new TypeReference<>() {
        };
        List<Property> properties = null;
        try {
            properties = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }

    @Override
    public void saveDistrict() {
        File file = null;
        try {
            file = ResourceUtils.getFile(propertyPathFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            objectMapper.writeValue(file, properties);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public Property getPropertyById(int id) {
        Property result = null;
        if (properties != null) {
            result = properties.stream()
                    .filter(house -> house.getId() == id)
                    .findAny().orElse(null);
        }
        return result;
    }
}
