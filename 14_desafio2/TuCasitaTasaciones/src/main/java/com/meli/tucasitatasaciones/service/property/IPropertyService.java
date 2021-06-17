package com.meli.tucasitatasaciones.service.property;

import com.meli.tucasitatasaciones.dto.PropertyDTO;

import java.util.List;

public interface IPropertyService {
    void createProperty(PropertyDTO property);
    List<PropertyDTO> getAllProperties();
}
