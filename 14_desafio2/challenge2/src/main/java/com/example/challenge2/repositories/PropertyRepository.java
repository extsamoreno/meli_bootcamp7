package com.example.challenge2.repositories;

import com.example.challenge2.models.Property;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public class PropertyRepository implements IPropertyRepository{

    @Override
    public Set<Property> findAll() {
        return null;
    }
}
