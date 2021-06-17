package com.example.challenge2.repositories;

import com.example.challenge2.models.Property;

public interface IPropertyDAO {
    Property findByName(String propertyName);

    Property save(Property property);

    boolean delete(String propertyName);
}
