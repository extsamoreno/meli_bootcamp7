package com.desafio2.demo.repository;

import com.desafio2.demo.dtos.DistrictDTO;
import com.desafio2.demo.dtos.PropertyDTO;
import com.desafio2.demo.exception.DistrictAlreadyExistException;
import com.desafio2.demo.exception.DistrictNotFoundException;
import com.desafio2.demo.exception.PropertyAlreadyExistException;
import com.desafio2.demo.exception.PropertyNotFoundException;
import com.desafio2.demo.model.District;
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
    private Map<Integer, District> districts;
    private String SCOPE;

    public PropertyRepository() {
        Properties properties =  new Properties();
        try {
            properties.load(new ClassPathResource("application.properties").getInputStream());
            this.SCOPE = properties.getProperty("api.scope");
            this.loadDataProperties();
            this.loadDataDistrict();
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
    public District saveDistrict(District district)
            throws DistrictAlreadyExistException {
        boolean exists = existsDistrict(district.getName());
        if(exists) {
            throw new DistrictAlreadyExistException(district.getName());
        }
        int newId = this.districts.size() + 1;
        district.setId(newId);
        districts.put(district.getId(), district);
        this.saveData(false);
        return district;
    }

    private boolean existsProperty(String name) {
        return properties.values().stream()
                .anyMatch(property -> property.getName().equals(name));
    }

    private boolean existsDistrict(String name) {
        return districts.values().stream()
                .anyMatch(district -> district.getName().equals(name));
    }

    @Override
    public Property getPropertyById(int propertyId) throws PropertyNotFoundException {
        loadDataProperties();

        return properties.values().stream()
                .filter(property -> property.getId() == propertyId)
                .findFirst().orElseThrow(() -> new PropertyNotFoundException(propertyId));
    }

    @Override
    public District getDistrictById(String district) throws DistrictNotFoundException {
        loadDataDistrict();

        return districts.values().stream()
                .filter(districtDTO -> districtDTO.getName().equals(district))
                .findFirst().orElseThrow(() -> new DistrictNotFoundException(district));
    }

    private void loadDataProperties() {
        List<Property> loadedData = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();
        File file;
        try {
            file = ResourceUtils.getFile( "./src/" + SCOPE + "/resources/properties.json");
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

    private void loadDataDistrict() {
        List<District> loadedData = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();
        File file;
        try {
            file = ResourceUtils.getFile("./src/" + SCOPE + "/resources/districts.json");
            loadedData = objectMapper.readValue(file, new TypeReference<List<District>>() {
            });
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Fail while initializing DB, check the files.");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Fail while initializing DB, check your JSON.");
        }

        this.districts = toDistrictMap(loadedData);
    }

    private Map<Integer, Property> toPropertyMap(List<Property> list) {
        Map<Integer, Property> map = new HashMap<>();
        for(Property dto : list) {
            map.put(dto.getId(), dto);
        }
        return map;
    }

    private Map<Integer, District> toDistrictMap(List<District> list) {
        Map<Integer, District> map = new HashMap<>();
        for(District district : list) {
            map.put(district.getId(), district);
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
                File file = ResourceUtils.getFile("./src/" + SCOPE + "/resources/districts.json");
                objectMapper.writeValue(file, this.districts);
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
