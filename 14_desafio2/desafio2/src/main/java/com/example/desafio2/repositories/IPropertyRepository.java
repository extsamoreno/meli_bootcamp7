package com.example.desafio2.repositories;

import com.example.desafio2.models.Property;

public interface IPropertyRepository {
    void add(Property property);
    Property getPropertyById(int propertyId);
}
