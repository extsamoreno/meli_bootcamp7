package com.example.desafio2.repositories;

import com.example.desafio2.exceptions.NeighborhoodNotFoundException;
import com.example.desafio2.exceptions.PropertyNotFoundException;
import com.example.desafio2.models.NeighborhoodDTO;
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
    private Map<Integer, NeighborhoodDTO> neighborhoods;
    private String SCOPE;

    public PropertyRepository() {
        Properties properties =  new Properties();

        try {
            properties.load(new ClassPathResource("application.properties").getInputStream());
            this.SCOPE = properties.getProperty("api.scope");
            this.loadDataProperties();
            this.loadDataNeighborhoods();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public PropertyDTO getPropertyById(int propertyId) throws PropertyNotFoundException {
        loadDataProperties();

        return properties.values().stream()
                .filter(propertyDTO -> propertyDTO.getId() == propertyId)
                .findFirst().orElseThrow(() -> new PropertyNotFoundException(propertyId));
    }

    @Override
    public NeighborhoodDTO getNeighborhoodById(String neighborhood) throws NeighborhoodNotFoundException {
        loadDataNeighborhoods();

        return neighborhoods.values().stream()
                .filter(neighborhoodDTO -> neighborhoodDTO.getName().equals(neighborhood))
                .findFirst().orElseThrow(() -> new NeighborhoodNotFoundException(neighborhood));
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

    private void loadDataNeighborhoods() {
        List<NeighborhoodDTO> loadedData = new ArrayList<>();

        ObjectMapper objectMapper = new ObjectMapper();
        File file;
        try {
            file = ResourceUtils.getFile("./src/" + SCOPE + "/resources/neighborhoods.json");
            loadedData = objectMapper.readValue(file, new TypeReference<List<NeighborhoodDTO>>() {
            });
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Failed while initializing DB, check your resources files");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed while initializing DB, check your JSON formatting.");
        }

        this.neighborhoods = toNeighborhoodMap(loadedData);
    }

    private Map<Integer, PropertyDTO> toPropertyMap(List<PropertyDTO> list) {
        Map<Integer, PropertyDTO> map = new HashMap<>();
        for(PropertyDTO dto : list) {
            map.put(dto.getId(), dto);
        }
        return map;
    }

    private Map<Integer, NeighborhoodDTO> toNeighborhoodMap(List<NeighborhoodDTO> list) {
        Map<Integer, NeighborhoodDTO> map = new HashMap<>();
        for(NeighborhoodDTO dto : list) {
            map.put(dto.getId(), dto);
        }
        return map;
    }

}
