package com.meli.tucasitatasaciones.repository.property;

import com.meli.tucasitatasaciones.model.Property;

import java.util.List;

public interface IPropertyRepository {
    void saveProperty(Property property);
    Property findPropertyById(Integer id);
    List<Property> getAllProperties();
}
