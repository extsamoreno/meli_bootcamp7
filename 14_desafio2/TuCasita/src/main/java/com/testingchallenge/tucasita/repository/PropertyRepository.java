package com.testingchallenge.tucasita.repository;

import com.testingchallenge.tucasita.exception.PropertyNotFoundException;
import com.testingchallenge.tucasita.model.Property;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class PropertyRepository implements iPropertyRepository {
    public static Map<String, Property> propertiesMap = new HashMap<>();

    @Override
    public Property getByName (String name) throws PropertyNotFoundException {
        Property property = propertiesMap.get(name);
        if (property == null) {
            throw new PropertyNotFoundException(name);
        } else {
            return property;
        }
    }

    @Override
    public HttpStatus addProperty(Property property) {
        propertiesMap.put(property.getName(), property);
        return HttpStatus.CREATED;
    }
}
