package com.example.testing.repositories;

import com.example.testing.model.Property;

public interface IPropertiesRepository {

    Property getPropertyById(int id);

    public void createProperty(Property p);

}
