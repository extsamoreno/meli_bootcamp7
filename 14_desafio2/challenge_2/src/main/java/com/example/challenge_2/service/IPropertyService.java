package com.example.challenge_2.service;

import com.example.challenge_2.exception.DistrictNotFoundException;
import com.example.challenge_2.exception.PropertyNotFoundException;
import com.example.challenge_2.service.dto.*;

import java.util.List;

public interface IPropertyService {

    NewIdDTO createProperty(PropertyDTO property) throws DistrictNotFoundException;

    SquareMetersDTO getSquareMeters(int propertyId) throws PropertyNotFoundException;

    PropertyPriceDTO getPropertyPrice(int propertyId) throws PropertyNotFoundException;

    EnvironmentDTO getBiggestEnvironment(int propertyId) throws PropertyNotFoundException;

    List<EnvironmentSquareMetersDTO> getSquareMetersEachEnvironment(int propertyId) throws PropertyNotFoundException;
}
