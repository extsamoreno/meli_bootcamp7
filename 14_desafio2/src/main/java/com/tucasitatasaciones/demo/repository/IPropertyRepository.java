package com.tucasitatasaciones.demo.repository;

import com.tucasitatasaciones.demo.models.Property;

public interface IPropertyRepository {
    Property addProperty(Property property);
    Property findPropertyByName(String name);
    Property findPropertyById(int id);
}
