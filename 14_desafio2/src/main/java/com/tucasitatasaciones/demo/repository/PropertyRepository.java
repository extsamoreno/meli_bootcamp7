package com.tucasitatasaciones.demo.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tucasitatasaciones.demo.models.Property;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

@Repository
public class PropertyRepository implements IPropertyRepository{

    private ArrayList<Property> listProperties = new ArrayList<>();
    @Override
    public Property addProperty(Property property) {
        listProperties.add(property);
        saveData(listProperties);
        return property;
    }

    private void saveData(ArrayList<Property> property) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            File file = ResourceUtils.getFile("classpath:properties.json");
            objectMapper.writeValue(file, "Hola mundoooooo");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Failed while writing to DB, check your resources files");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed while writing to DB, check your JSON formatting.");
        }
    }
}
