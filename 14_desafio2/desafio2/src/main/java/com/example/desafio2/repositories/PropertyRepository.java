package com.example.desafio2.repositories;

import com.example.desafio2.exceptions.PropertyAlreadyExistException;
import com.example.desafio2.exceptions.PropertyNotFoundException;
import com.example.desafio2.models.PropertyDTO;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

@Repository
public class PropertyRepository implements IPropertyRepository {

    private Map<Integer, PropertyDTO> properties;
    private String SCOPE;

    public PropertyRepository() {
        Properties properties =  new Properties();

        try {
            properties.load(new ClassPathResource("application.properties").getInputStream());
            this.SCOPE = properties.getProperty("api.scope");
            this.loadDataProperties();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public PropertyDTO saveProperty(PropertyDTO propertyDTO) throws PropertyAlreadyExistException {
        boolean exists = existsProperty(propertyDTO.getName());

        if(exists) {
            throw new PropertyAlreadyExistException(propertyDTO.getName());
        }

        int newId = this.properties.size() + 1;
        propertyDTO.setId(newId);
        properties.put(propertyDTO.getId(), propertyDTO);

        this.saveData();

        return propertyDTO;
    }

    private boolean existsProperty(String name) {
        return properties.values().stream()
                .anyMatch(propertyDTO -> propertyDTO.getName().equals(name));
    }

    @Override
    public PropertyDTO getPropertyById(int propertyId) throws PropertyNotFoundException {
        loadDataProperties();

        return properties.values().stream()
                .filter(propertyDTO -> propertyDTO.getId() == propertyId)
                .findFirst().orElseThrow(() -> new PropertyNotFoundException(propertyId));
    }

    private void loadDataProperties() {
        List<PropertyDTO> loadedData = new ArrayList<>();

        ObjectMapper objectMapper = new ObjectMapper();
        File file;
        try {
            file = ResourceUtils.getFile("./src/" + SCOPE + "/resources/properties.json");
            loadedData = objectMapper.readValue(file, new TypeReference<List<PropertyDTO>>() {
            });
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Failed while initializing DB, check your resources files");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed while initializing DB, check your JSON formatting.");
        }

        this.properties = toPropertyMap(loadedData);
    }

    private Map<Integer, PropertyDTO> toPropertyMap(List<PropertyDTO> list) {
        Map<Integer, PropertyDTO> map = new HashMap<>();
        for(PropertyDTO dto : list) {
            map.put(dto.getId(), dto);
        }
        return map;
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
