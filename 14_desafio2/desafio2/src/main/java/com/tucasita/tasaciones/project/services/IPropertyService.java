package com.tucasita.tasaciones.project.services;

import com.tucasita.tasaciones.project.exceptions.PropertyAlreadyExistsException;
import com.tucasita.tasaciones.project.exceptions.PropertyDistrictNameNotFoundException;
import com.tucasita.tasaciones.project.exceptions.PropertyNameNotFoundException;
import com.tucasita.tasaciones.project.services.Dto.PropertyDto;
import com.tucasita.tasaciones.project.services.Dto.PropertyEnvironmentDto;
import com.tucasita.tasaciones.project.services.Dto.PropertyTotalSquareMetersDto;
import com.tucasita.tasaciones.project.services.Dto.PropertyValueDto;

import java.util.ArrayList;

public interface IPropertyService {
    PropertyTotalSquareMetersDto getTotalSquareMeters(String propertyName) throws PropertyNameNotFoundException;

    PropertyValueDto getPropertyValue(String propertyName) throws PropertyNameNotFoundException, PropertyDistrictNameNotFoundException;

    PropertyEnvironmentDto getBiggestEnvironment(String propertyName) throws PropertyNameNotFoundException;

    ArrayList<PropertyEnvironmentDto> getEnvironmentSizesList(String propertyName) throws PropertyNameNotFoundException;

    void addNewProperty (PropertyDto propertyDto) throws PropertyAlreadyExistsException, PropertyDistrictNameNotFoundException;
}
