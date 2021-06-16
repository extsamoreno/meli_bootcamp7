package com.meli.tucasitatasaciones.service;

import com.meli.tucasitatasaciones.dto.PropertyDTO;

public interface IPropertyService {
    void createProperty(PropertyDTO property);
    PropertyDTO findProperty(Integer id);
}
