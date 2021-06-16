package com.tucasitatasaciones.demo.service;

import com.tucasitatasaciones.demo.dto.PropertyDTO;
import com.tucasitatasaciones.demo.exception.ResponseException;

public interface IPropertyService {
    PropertyDTO addProperty(PropertyDTO property);
}
