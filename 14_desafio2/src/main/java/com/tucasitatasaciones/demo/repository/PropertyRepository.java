package com.tucasitatasaciones.demo.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.tucasitatasaciones.demo.models.District;
import com.tucasitatasaciones.demo.models.Property;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Properties;

@Repository
public class PropertyRepository implements IPropertyRepository{

    private ArrayList<Property> listProperties;

    @Override
    public Property addProperty(Property property) {
        loadData();
        property.setId(listProperties.size() + 1);
        listProperties.add(property);
        saveData(listProperties);
        return property;
    }

    @Override
    public Property findPropertyByName(String name) {
        loadData();
        Property property = listProperties.stream()
                                .filter(p -> p.getName().toLowerCase().equals(name.toLowerCase()))
                                .findFirst()
                                .orElse(null);
        return property;
    }

    @Override
    public Property findPropertyById(int id) {
        loadData();
        Property property = listProperties.stream()
                                .filter(p -> p.getId() == id)
                                .findFirst()
                                .orElse(null);
        return property;
    }

    private void saveData(ArrayList<Property> property) {
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectWriter writer = objectMapper.writer(new DefaultPrettyPrinter());
        try {
            File file = ResourceUtils.getFile("./src/main/resources/properties.json");
            writer.writeValue(file, property);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Failed while writing to DB, check your resources files");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed while writing to DB, check your JSON formatting.");
        }
    }

    private void loadData() {
        ArrayList<Property> loadedData = new ArrayList<>();

        ObjectMapper objectMapper = new ObjectMapper();
        File file;
        try {
            file = ResourceUtils.getFile("./src/main/resources/properties.json");
            loadedData = objectMapper.readValue(file, new TypeReference<ArrayList<Property>>(){});
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Failed while initializing DB, check your resources files");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed while initializing DB, check your JSON formatting.");
        }

        this.listProperties = loadedData;
    }
}
