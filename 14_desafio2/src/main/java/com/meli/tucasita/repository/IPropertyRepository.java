package com.meli.tucasita.repository;

import com.meli.tucasita.models.Property;

public interface IPropertyRepository {

    boolean propertyAlreadyExists(String name);

    void insertNewProperty(Property property);

    void loadData();

    void saveDataIntoJson();

}
