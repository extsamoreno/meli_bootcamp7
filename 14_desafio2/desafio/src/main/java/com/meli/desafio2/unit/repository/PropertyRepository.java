package com.meli.desafio2.unit.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.meli.desafio2.exception.PropertyAlreadyExistsException;
import com.meli.desafio2.model.District;
import com.meli.desafio2.model.Property;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

@Repository
public class PropertyRepository implements IPropertyRepository {

    private String SCOPE;
    private Hashtable<String, Double> districts;
    private Hashtable<Long, Property> properties;

    public PropertyRepository() {
        Properties properties =  new Properties();

        try {
            properties.load(new ClassPathResource("application.properties").getInputStream());
            this.SCOPE = properties.getProperty("api.scope");
            this.districts = LoadDistrictDataBase();
            this.properties = LoadPropertyDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void create(Property prop) {
        if (properties.containsKey(prop.getId())) throw new PropertyAlreadyExistsException(prop.getId());
        properties.put(prop.getId(), prop);
        persistDataBase();
    }

    @Override
    public Property fetch(Long id) {
        return properties.get(id);
    }

    @Override
    public Double fetch(String name) {
        return districts.get(name);
    }


    private Hashtable<String, Double> LoadDistrictDataBase() {
        Set<District> loadedData = new HashSet<>();
        Hashtable<String, Double> districts = new Hashtable<>();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            File file = ResourceUtils.getFile("./src/" + SCOPE + "/resources/districts.json");
            loadedData = objectMapper.readValue(file, new TypeReference<Set<District>>(){});

            for (District district: loadedData) {
                districts.put(district.getName(), district.getPrice());
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Failed while initializing DB, check your resources files");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed while initializing DB, check your JSON formatting.");
        }

        return districts;
    }


    private Hashtable<Long, Property> LoadPropertyDataBase() {
        Set<Property> loadedData = new HashSet<>();
        Hashtable<Long, Property> propertiesTable = new Hashtable<>();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            File file = ResourceUtils.getFile("./src/" + SCOPE + "/resources/properties.json");
            loadedData = objectMapper.readValue(file, new TypeReference<Set<Property>>(){});


            for (Property property: loadedData) {
                propertiesTable.put(property.getId(), property);
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Failed while initializing DB, check your resources files");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed while initializing DB, check your JSON formatting.");
        }

        return propertiesTable;
    }

    private void persistDataBase() {
        File file = null;
        try {
            file = ResourceUtils.getFile( "./src/" + SCOPE + "/resources/properties.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        List<Property> properties_list = new ArrayList<>();
        properties.forEach((k, v) -> properties_list.add(v));
        ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());

        try {
            objectMapper.writeValue(file, properties_list);
        } catch (IOException e) {
            e.printStackTrace();
        }

        file = null;
        try {
            file = ResourceUtils.getFile( "./src/" + SCOPE + "/resources/districts.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        List<District> districts_list = new ArrayList<>();
        districts.forEach((k, v) -> districts_list.add(new District(k,v)));

        try {
            objectMapper.writeValue(file, districts_list);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
