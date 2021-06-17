package com.tucasitaTasaciones.service;

import com.tucasitaTasaciones.dto.PropertyDTO;
import com.tucasitaTasaciones.model.Property;

import java.util.List;

public interface IPropertyService {
    void addNewProperty(PropertyDTO property);

    List<Property> getProperties();
}
