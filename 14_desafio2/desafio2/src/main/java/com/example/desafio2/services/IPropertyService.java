package com.example.desafio2.services;

import com.example.desafio2.dtos.ResponseBiggestEnvironmentDTO;
import com.example.desafio2.dtos.ResponsePropertySquareDTO;
import com.example.desafio2.dtos.ResponsePropertyValueDTO;
import com.example.desafio2.dtos.ResponseSquareMetersEnvironmentDTO;
import com.example.desafio2.exceptions.PropertyException;
import com.example.desafio2.exceptions.PropertyNotFoundException;

public interface IPropertyService {

    ResponsePropertySquareDTO getSquareMeters(int propertyId) throws PropertyNotFoundException;
    ResponsePropertyValueDTO getPropertyValue(int propertyId) throws PropertyException;
    ResponseBiggestEnvironmentDTO getBiggestEnvironment(int propertyId) throws PropertyNotFoundException;
    ResponseSquareMetersEnvironmentDTO getSquareMetersOfEnvironments(int propertyId) throws PropertyNotFoundException;

}
