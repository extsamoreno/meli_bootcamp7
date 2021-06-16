package com.meli.tucasita.repository;

import com.meli.tucasita.exception.PropertyNotFoundException;
import com.meli.tucasita.model.Property;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class PropertyRepository implements IPropertyRepository{
    public static Map<String, Property> properties= new HashMap<>();

    @Override
    public Property getPropertyByName(String name) throws PropertyNotFoundException {
        Property prop= properties.get(name);
        if (prop==null){
            throw new PropertyNotFoundException(name);
        }
        return prop;
    }
}
