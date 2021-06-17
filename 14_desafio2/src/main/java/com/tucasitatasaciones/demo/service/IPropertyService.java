package com.tucasitatasaciones.demo.service;

import com.tucasitatasaciones.demo.dto.*;
import com.tucasitatasaciones.demo.exception.BadRequestException;

public interface IPropertyService {
    PropertyDTO addProperty(PropertyDTO property) throws BadRequestException;
    PropertySquareMettersDTO calculateSquareMettersById(int id) throws BadRequestException;
    PropertyPriceDTO calculatePropertyPriceById(int id) throws BadRequestException;
    PropertyBiggestEnvironmentDTO calculateBiggestEnvironmentById(int id) throws BadRequestException;
    PropertyEnvironmentSquareMetterDTO calculateSquareMettersEnvironmentsById(int id) throws BadRequestException;
    PropertyDTO findPropertyById(int id) throws BadRequestException;
}
