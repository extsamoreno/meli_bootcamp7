package com.example.desafio2.services;

import com.example.desafio2.dtos.ResponseBiggestEnvironmentDTO;
import com.example.desafio2.dtos.ResponsePropertySquareDTO;
import com.example.desafio2.dtos.ResponsePropertyValueDTO;
import com.example.desafio2.dtos.ResponseSquareMetersEnvironmentDTO;
import com.example.desafio2.exceptions.NeighborhoodAlreadyExistException;
import com.example.desafio2.exceptions.PropertyAlreadyExistException;
import com.example.desafio2.exceptions.PropertyException;
import com.example.desafio2.exceptions.PropertyNotFoundException;
import com.example.desafio2.models.NeighborhoodDTO;
import com.example.desafio2.models.PropertyDTO;

public interface IPropertyService {

    PropertyDTO createProperty(PropertyDTO propertyDTO) throws PropertyAlreadyExistException;
    NeighborhoodDTO createNeighborhood(NeighborhoodDTO neighborhoodDTO) throws NeighborhoodAlreadyExistException;
    ResponsePropertySquareDTO getSquareMeters(int propertyId) throws PropertyNotFoundException;
    ResponsePropertyValueDTO getPropertyValue(int propertyId) throws PropertyException;
    ResponseBiggestEnvironmentDTO getBiggestEnvironment(int propertyId) throws PropertyNotFoundException;
    ResponseSquareMetersEnvironmentDTO getSquareMetersOfEnvironments(int propertyId) throws PropertyNotFoundException;

}
