package com.bootcamp.tucasitatasaciones.repository;

import com.bootcamp.tucasitatasaciones.model.District;
import com.bootcamp.tucasitatasaciones.model.Property;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class DatatRepository implements IDatatRepository {

    static List<District> districts = loadDistricts();
    static List<Property> properties = new ArrayList<>();

    @Override
    public District findDistrictById(Long id) {
        return districts.stream()
                .filter(dist -> dist.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public District findDistrictByName(String name) {
        return districts.stream()
                .filter(dist -> dist.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Property findPropertyById(Long id) {
        return properties.stream()
                .filter(prop -> prop.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void saveProperty(Property property) {
        Long id = properties.size() + 1L;
        property.setId(id);

        properties.add(property);
    }

    @Override
    public List<Property> getAllProperties() {
        return properties;
    }

    private static List<District> loadDistricts() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:districts.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<District>> typeRef = new TypeReference<>() {
        };
        List<District> districts = null;

        try {
            districts = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return districts;
    }
}
