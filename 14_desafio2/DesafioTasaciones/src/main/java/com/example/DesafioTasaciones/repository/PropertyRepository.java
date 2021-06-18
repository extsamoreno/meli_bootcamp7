package com.example.DesafioTasaciones.repository;

import com.example.DesafioTasaciones.exceptions.PropertyNotFoundException;
import com.example.DesafioTasaciones.models.District;
import com.example.DesafioTasaciones.models.Property;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class PropertyRepository implements IPropertyRepository {
    private final List<District> districts;
    private final List<Property> properties;

    public PropertyRepository() {
        this.districts = loadDatabase();
        this.properties = new ArrayList<>();
    }


    @Override
    public District findDistrictByName(String name) {
        District district = null;

        if(this.districts != null) {
            Optional<District> item = this.districts.stream().filter(distr -> distr.getName().equals(name)).findFirst();
            if(item.isPresent())
                district = item.get();
        }

        return district;
    }

    private List<District> loadDatabase() {
        File file = null;

        try {
            file = ResourceUtils.getFile("classpath:districts.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<District>> typeRef = new TypeReference<>() {};

        List<District> districts = null;

        try {
            districts = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return districts;
    }


    @Override
    public void saveProperty(Property property) {
        property.setId(this.properties.size() + 1);
        this.properties.add(property);
    }

    @Override
    public Property findPropertyById(Integer id) {
        return this.properties.stream().filter(prop -> prop.getId().equals(id)).findFirst().orElseThrow(() -> new PropertyNotFoundException(id));
    }

    @Override
    public List<Property> getAllProperties() {
        return this.properties;
    }

}
