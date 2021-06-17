package com.meli.desafio2.repository;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import com.meli.desafio2.exception.DistrictIdNotFoundException;
import com.meli.desafio2.exception.PropertyIdAlreadyExistException;
import com.meli.desafio2.exception.PropertyIdNotFoundException;
import com.meli.desafio2.model.District;
import com.meli.desafio2.model.Environment;
import com.meli.desafio2.model.Property;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PropertyRepository implements IPropertyRepository {

    @Autowired
    IDistrictRepository districtRepository;

    // List with all properties
    List<Property> properties;

    public PropertyRepository() {
        properties = loadProperties();
    }

    // Find a property by ID
    @Override
    public Property getPropertybyId(Integer propId) throws PropertyIdNotFoundException {

        Property prop = properties.stream().filter(i -> i.getId().equals(propId)).findFirst().orElse(null);

        if(prop == null){
            throw new PropertyIdNotFoundException(propId);
        }
        return prop;
    }

    // Create a new property
    @Override
    public void createProperty(Property prop) throws PropertyIdAlreadyExistException, DistrictIdNotFoundException {

        Property newProp = properties.stream().filter(i -> i.getId().equals(prop.getId())).findFirst().orElse(null);

        if(newProp != null) {
            throw new PropertyIdAlreadyExistException(prop.getId());
        }

        districtRepository.getDistrictbyId(prop.getDistrictId());
        properties.add(prop);
    }

    // Load default properties
    private List<Property> loadProperties(){

        List<Property> defaultProperties = new ArrayList<>();

        // Property 1
        Property prop1 = new Property();
        prop1.setId(0);
        prop1.setName("House 1");
        List<Environment> environments1 = new ArrayList<>();

        prop1.setDistrictId(0);
        environments1.add(new Environment("Room 1", 20.0, 30.0));
        environments1.add(new Environment("Room 2", 25.0, 20.0));
        environments1.add(new Environment("Room 3", 10.0, 10.0));
        prop1.setEnvironments(environments1);

        // Property 2
        Property prop2 = new Property();
        prop2.setId(1);
        prop2.setName("House 2");
        List<Environment> environments2 = new ArrayList<>();

        prop2.setDistrictId(3);
        environments2.add(new Environment("Room", 10.0, 10.0));
        environments2.add(new Environment("Garden", 15.0, 15.0));
        prop2.setEnvironments(environments2);

        defaultProperties.add(prop1);
        defaultProperties.add(prop2);

        return defaultProperties;
    }
}
