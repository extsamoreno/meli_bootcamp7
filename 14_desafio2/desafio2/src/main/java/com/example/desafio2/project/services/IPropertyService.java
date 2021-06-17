package com.example.desafio2.project.services;

import com.example.desafio2.project.exceptions.PropertyAlreadyExistsException;
import com.example.desafio2.project.exceptions.PropertyDistrictNameNotFoundException;
import com.example.desafio2.project.exceptions.PropertyNameNotFoundException;
import com.example.desafio2.project.services.Dto.PropertyDto;
import com.example.desafio2.project.services.Dto.PropertyEnvironmentDto;
import com.example.desafio2.project.services.Dto.PropertyTotalSquareMetersDto;
import com.example.desafio2.project.services.Dto.PropertyValueDto;

import java.util.ArrayList;

public interface IPropertyService {
    PropertyTotalSquareMetersDto getTotalSquareMeters(String propertyName) throws PropertyNameNotFoundException;

    PropertyValueDto getPropertyValue(String propertyName) throws PropertyNameNotFoundException, PropertyDistrictNameNotFoundException;

    PropertyEnvironmentDto getBiggestEnvironment(String propertyName) throws PropertyNameNotFoundException;

    ArrayList<PropertyEnvironmentDto> getEnvironmentSizesList(String propertyName) throws PropertyNameNotFoundException;

    void addNewProperty (PropertyDto propertyDto) throws PropertyAlreadyExistsException, PropertyDistrictNameNotFoundException;
}
