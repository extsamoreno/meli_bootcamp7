package com.meli.tucasitatasaciones.repository.property;

import com.meli.tucasitatasaciones.model.Property;

public interface IPropertyRepository {
    void saveProperty(Property property);
    Property findPropertyById(Integer id);
}
