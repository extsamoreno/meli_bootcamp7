package com.bootcamp.tucasitatasaciones.repository;

import com.bootcamp.tucasitatasaciones.model.District;
import com.bootcamp.tucasitatasaciones.model.Property;

import java.util.List;

public interface IDataRepository {

    District findDistrictById(Long id);

    District findDistrictByName(String name);

    Property findPropertyById(Long id);

    void saveProperty(Property property);

    List<Property> getAllProperties();
}
