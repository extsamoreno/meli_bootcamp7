package com.desafio2.demo.service;

import com.desafio2.demo.dtos.ResponseBiggestEnvironmentDTO;
import com.desafio2.demo.dtos.ResponsePropertySquareDTO;
import com.desafio2.demo.dtos.ResponsePropertyValueDTO;
import com.desafio2.demo.dtos.ResponseSquareMetersEnvironmentDTO;
import com.desafio2.demo.exception.NeighborhoodAlreadyExistException;
import com.desafio2.demo.exception.PropertyAlreadyExistException;
import com.desafio2.demo.exception.PropertyException;
import com.desafio2.demo.exception.PropertyNotFoundException;
import com.desafio2.demo.model.Neighborhood;
import com.desafio2.demo.model.Property;

public interface IPropertyService {

    ResponsePropertySquareDTO getSquareMeters(int propertyId) throws PropertyNotFoundException;
    ResponsePropertyValueDTO getPropertyValue(int propertyId) throws PropertyException;
    ResponseBiggestEnvironmentDTO getBiggestEnvironment(int propertyId) throws PropertyNotFoundException;
    ResponseSquareMetersEnvironmentDTO getSquareMetersOfEnvironments(int propertyId) throws PropertyNotFoundException;
    Property createProperty(Property propertyDTO) throws PropertyAlreadyExistException;
    Neighborhood createNeighborhood(Neighborhood neighborhoodDTO) throws NeighborhoodAlreadyExistException;
}
