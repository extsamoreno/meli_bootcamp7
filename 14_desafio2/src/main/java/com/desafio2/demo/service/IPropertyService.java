package com.desafio2.demo.service;

import com.desafio2.demo.dtos.*;
import com.desafio2.demo.exception.DistrictAlreadyExistException;
import com.desafio2.demo.exception.PropertyAlreadyExistException;
import com.desafio2.demo.exception.PropertyException;
import com.desafio2.demo.exception.PropertyNotFoundException;
import com.desafio2.demo.model.District;
import com.desafio2.demo.model.Property;

public interface IPropertyService {

    SquareMetersPropertyDTO getSquareMeters(int propertyId) throws PropertyNotFoundException;
    PropertyPriceDTO getPropertyPrice(int propertyId) throws PropertyException;
    EnvironmentBiggestDTO getBiggestEnvironment(int propertyId) throws PropertyNotFoundException;
    SquareMetersEnvironmentDTO getSquareMetersEnvironments(int propertyId) throws PropertyNotFoundException;
    Property createProperty(Property property) throws PropertyAlreadyExistException;
    District createDistrict(District district) throws DistrictAlreadyExistException;
}
