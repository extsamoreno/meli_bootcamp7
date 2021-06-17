package com.tucasitaTasaciones.repository;

import com.tucasitaTasaciones.model.Property;

import java.util.List;

public interface IPropertyRepository {
    void addNewProperty(Property property);

    Property findProperty(Integer id);

    List<Property> getProperties();
}
