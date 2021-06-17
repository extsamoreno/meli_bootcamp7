package com.example.challenge_2.repository;

import com.example.challenge_2.exception.PropertyNotFoundException;
import com.example.challenge_2.models.Property;

public interface IPropertyRepository {

    boolean add(Property propertyMapped);

    Property getById(int propertyId) throws PropertyNotFoundException;
}

