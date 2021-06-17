package com.example.challenge2.repositories;

import com.example.challenge2.exceptions.PropertyNotFoundException;
import com.example.challenge2.models.Property;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@Repository
public class PropertyDAO implements IPropertyDAO {

    private String SCOPE;
    Set<Property> properties;

    @Override
    public Property findByName(String propertyName) {
        loadData();
        return properties.stream()
                .filter(prop -> prop.getName().equals(propertyName))
                .findFirst().orElseThrow(() -> new PropertyNotFoundException(propertyName));
    }

    @Override
    public Property save(Property property) {
        this.delete(property.getName());
        properties.add(property);
        this.saveData();
        return property;
    }

    @Override
    public boolean delete(String propertyName) {
        boolean ret = false;

        try {
            Property found = this.findByName(propertyName);

            properties.remove(found);
            ret = true;
            this.saveData();

        } catch (PropertyNotFoundException e) {
        }

        return ret;
    }

    private void saveData() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            File file = ResourceUtils.getFile("./src/" + SCOPE + "/resources/users.json");
            objectMapper.writeValue(file, this.properties);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Failed while writing to DB, check your resources files");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed while writing to DB, check your JSON formatting.");
        }
    }


    private void loadData() {
        Set<Property> loadedData = new HashSet<>();

        ObjectMapper objectMapper = new ObjectMapper();
        File file;
        try {
            file = ResourceUtils.getFile("./src/" + SCOPE + "/resources/property.json");
            loadedData = objectMapper.readValue(file, new TypeReference<Set<Property>>() {
            });
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Failed while initializing DB, check your resources files");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed while initializing DB, check your JSON formatting.");
        }

        this.properties = loadedData;
    }


}
