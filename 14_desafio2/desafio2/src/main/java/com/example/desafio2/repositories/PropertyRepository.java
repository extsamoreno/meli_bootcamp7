package com.example.desafio2.repositories;

import com.example.desafio2.exceptions.NeighborhoodAlreadyExistException;
import com.example.desafio2.exceptions.NeighborhoodNotFoundException;
import com.example.desafio2.exceptions.PropertyAlreadyExistException;
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
    public PropertyDTO saveProperty(PropertyDTO propertyDTO) throws PropertyAlreadyExistException {
        boolean exists = existsProperty(propertyDTO.getName());

        if(exists) {
            throw new PropertyAlreadyExistException(propertyDTO.getName());
        }

        int newId = this.properties.size() + 1;
        propertyDTO.setId(newId);
        properties.put(propertyDTO.getId(), propertyDTO);

        this.saveData(true);

        return propertyDTO;
    }

    @Override
    public NeighborhoodDTO saveNeighborhood(NeighborhoodDTO neighborhoodDTO)
            throws NeighborhoodAlreadyExistException {
        boolean exists = existsNeighborhood(neighborhoodDTO.getName());

        if(exists) {
            throw new NeighborhoodAlreadyExistException(neighborhoodDTO.getName());
        }

        int newId = this.neighborhoods.size() + 1;
        neighborhoodDTO.setId(newId);
        neighborhoods.put(neighborhoodDTO.getId(), neighborhoodDTO);

        this.saveData(false);

        return neighborhoodDTO;
    }

    private boolean existsProperty(String name) {
        return properties.values().stream()
                .anyMatch(propertyDTO -> propertyDTO.getName().equals(name));
    }

    private boolean existsNeighborhood(String name) {
        return neighborhoods.values().stream()
                .anyMatch(neighborhoodDTO -> neighborhoodDTO.getName().equals(name));
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
            System.out.println("Failed while writing to DB, check your resources files");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed while writing to DB, check your JSON formatting.");
        }
    }

}
