package com.example.challenge2.repository;

import com.example.challenge2.models.Property;
import org.springframework.stereotype.Repository;

import javax.el.PropertyNotFoundException;
import java.util.HashMap;
import java.util.Map;

@Repository
public class PropertyRepository implements IPropertyRepository{
    public static Map<String, Property> property= new HashMap<>();

    @Override
    public Property getPropertyByName(String name) throws PropertyNotFoundException {
        Property prop= property.get(name);
        if (prop==null){
            throw new PropertyNotFoundException(name);
        }
        return prop;
        }
    }
