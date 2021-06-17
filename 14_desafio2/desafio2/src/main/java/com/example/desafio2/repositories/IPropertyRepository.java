package com.example.desafio2.repositories;

import com.example.desafio2.models.Property;

public interface IPropertyRepository {
    int add(Property property);
    Property getPropertyById(int propertyId);
}

