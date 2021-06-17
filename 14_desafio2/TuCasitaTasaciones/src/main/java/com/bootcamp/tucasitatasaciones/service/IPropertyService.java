package com.bootcamp.tucasitatasaciones.service;

import com.bootcamp.tucasitatasaciones.DTO.PropertyDTO;
import com.bootcamp.tucasitatasaciones.DTO.TotalSquareMetersDTO;
import com.bootcamp.tucasitatasaciones.exception.NotFoundException;
import com.bootcamp.tucasitatasaciones.model.Property;

import java.util.List;

public interface IPropertyService {

    void registerProperty(PropertyDTO propertyDTO) throws NotFoundException;

    public List<Property> getAllProperties();

    TotalSquareMetersDTO getTotalSquareMeters(Long propertyId) throws NotFoundException;

}
