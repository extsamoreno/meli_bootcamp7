package com.tucasitaTasaciones.service;

import com.tucasitaTasaciones.dto.PropertyDTO;

import java.util.List;

public interface IPropertyService {

    void addNewProperty(PropertyDTO property);

    List<PropertyDTO> getProperties();
}
