package com.bootcamp.tucasitatasaciones.service;

import com.bootcamp.tucasitatasaciones.DTO.PropertyDTO;
import com.bootcamp.tucasitatasaciones.exception.DistrictNotFoundException;

public interface IPropertyService {

    void registerProperty(PropertyDTO propertyDTO) throws DistrictNotFoundException;

}
