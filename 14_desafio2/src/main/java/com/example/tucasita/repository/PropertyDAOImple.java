package com.example.tucasita.repository;

import com.example.tucasita.exception.ExistentPropertyException;
import com.example.tucasita.exception.PropertyNotFoundException;
import com.example.tucasita.model.PropertyDTO;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

@Repository
public class PropertyDAOImple implements PropertyDAO{

    private Set<PropertyDTO> properties;
    private String SCOPE;

    public PropertyDAOImple() {
        Properties properties =  new Properties();

        try {
            properties.load(new ClassPathResource("application.properties").getInputStream());
            this.SCOPE = properties.getProperty("api.scope");
            this.loadData();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void create(PropertyDTO property) {
        try {
            if (this.findById(property.getPropId()) != null) {
                throw new ExistentPropertyException(property.getPropId());
            }
        } catch (PropertyNotFoundException e) {
            properties.add(property);

            this.saveData();
        }
    }

    @Override
    public PropertyDTO findById(int idProperty) {
        loadData();
        return properties.stream()
                .filter(property -> property.getPropId() == idProperty)
                .findFirst().orElseThrow(() -> new PropertyNotFoundException(idProperty));
    }

    private void loadData() {
        Set<PropertyDTO> loadedData = new HashSet<>();

        ObjectMapper objectMapper = new ObjectMapper();
        File file;
        try {
            file = ResourceUtils.getFile("./src/" + SCOPE + "/resources/properties.json");
            loadedData = objectMapper.readValue(file, new TypeReference<Set<PropertyDTO>>(){});
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Failed while initializing DB, check your resources files");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed while initializing DB, check your JSON formatting.");
        }

        this.properties = loadedData;
    }

    private void saveData() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            File file = ResourceUtils.getFile("./src/" + SCOPE + "/resources/properties.json");
            objectMapper.writeValue(file, this.properties);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Failed while writing to DB, check your resources files");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed while writing to DB, check your JSON formatting.");
        }
    }
}
