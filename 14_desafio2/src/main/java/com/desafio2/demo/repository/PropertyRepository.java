package com.desafio2.demo.repository;

import com.desafio2.demo.exception.NeighborhoodAlreadyExistException;
import com.desafio2.demo.exception.NeighborhoodNotFoundException;
import com.desafio2.demo.exception.PropertyAlreadyExistException;
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
public class PropertyRepository implements IPropertyRepository{

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
    public Property saveProperty(Property property) throws PropertyAlreadyExistException {
        boolean exists = existsProperty(property.getName());

        if(exists) {
            throw new PropertyAlreadyExistException(property.getName());
        }

        int newId = this.properties.size() + 1;
        property.setId(newId);
        properties.put(property.getId(), property);

        this.saveData(true);

        return property;
    }

    @Override
    public Neighborhood saveNeighborhood(Neighborhood neighborhood)
            throws NeighborhoodAlreadyExistException {
        boolean exists = existsNeighborhood(neighborhood.getName());

        if(exists) {
            throw new NeighborhoodAlreadyExistException(neighborhood.getName());
        }

        int newId = this.neighborhoods.size() + 1;
        neighborhood.setId(newId);
        neighborhoods.put(neighborhood.getId(), neighborhood);

        this.saveData(false);

        return neighborhood;
    }

    private boolean existsProperty(String name) {
        return properties.values().stream()
                .anyMatch(property -> property.getName().equals(name));
    }

    private boolean existsNeighborhood(String name) {
        return neighborhoods.values().stream()
                .anyMatch(neighborhood -> neighborhood.getName().equals(name));
    }

    @Override
    public Property getPropertyById(int propertyId) throws PropertyNotFoundException {
        loadDataProperties();

        return properties.values().stream()
                .filter(property -> property.getId() == propertyId)
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
            System.out.println("Fail while initializing DB, check the files.");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Fail while initializing DB, check your JSON.");
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
            System.out.println("Fail while initializing DB, check the files.");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Fail while initializing DB, check your JSON.");
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

    private void saveData(boolean isProperties) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            if(isProperties) {
                File file = ResourceUtils.getFile("./src/" + SCOPE + "/resources/properties.json");
                objectMapper.writeValue(file, this.properties);
            } else {
                File file = ResourceUtils.getFile("./src/" + SCOPE + "/resources/neighborhoods.json");
                objectMapper.writeValue(file, this.neighborhoods);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Fail while initializing DB, check the files.");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Fail while initializing DB, check your JSON.");
        }
    }

}
