package com.desafio2.demo.repository;

import com.desafio2.demo.exception.NeighborhoodNotFoundException;
import com.desafio2.demo.exception.PropertyNotFoundException;
import com.desafio2.demo.model.Neighborhood;
import com.desafio2.demo.model.Property;
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

    private Map<Integer, Property> properties;
    private Map<Integer, Neighborhood> neighborhoods;
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
    public Property getPropertyById(int propertyId) throws PropertyNotFoundException {
        loadDataProperties();

        return properties.values().stream()
                .filter(propertyDTO -> propertyDTO.getId() == propertyId)
                .findFirst().orElseThrow(() -> new PropertyNotFoundException(propertyId));
    }

    @Override
    public Neighborhood getNeighborhoodById(String neighborhood) throws NeighborhoodNotFoundException {
        loadDataNeighborhoods();

        return neighborhoods.values().stream()
                .filter(neighborhoodDTO -> neighborhoodDTO.getName().equals(neighborhood))
                .findFirst().orElseThrow(() -> new NeighborhoodNotFoundException(neighborhood));
    }

    private void loadDataProperties() {
        List<Property> loadedData = new ArrayList<>();

        ObjectMapper objectMapper = new ObjectMapper();
        File file;
        try {
            file = ResourceUtils.getFile("./src/" + SCOPE + "/resources/properties.json");
            loadedData = objectMapper.readValue(file, new TypeReference<List<Property>>() {
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
        List<Neighborhood> loadedData = new ArrayList<>();

        ObjectMapper objectMapper = new ObjectMapper();
        File file;
        try {
            file = ResourceUtils.getFile("./src/" + SCOPE + "/resources/neighborhoods.json");
            loadedData = objectMapper.readValue(file, new TypeReference<List<Neighborhood>>() {
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

    private Map<Integer, Property> toPropertyMap(List<Property> list) {
        Map<Integer, Property> map = new HashMap<>();
        for(Property dto : list) {
            map.put(dto.getId(), dto);
        }
        return map;
    }

    private Map<Integer, Neighborhood> toNeighborhoodMap(List<Neighborhood> list) {
        Map<Integer, Neighborhood> map = new HashMap<>();
        for(Neighborhood dto : list) {
            map.put(dto.getId(), dto);
        }
        return map;
    }

}
