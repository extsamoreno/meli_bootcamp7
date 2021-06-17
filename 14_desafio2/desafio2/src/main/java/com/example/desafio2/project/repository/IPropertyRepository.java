package com.example.desafio2.project.repository;

import com.example.desafio2.project.exceptions.PropertyAlreadyExistsException;
import com.example.desafio2.project.exceptions.PropertyDistrictNameNotFoundException;
import com.example.desafio2.project.exceptions.PropertyNameNotFoundException;
import com.example.desafio2.project.models.District;
import com.example.desafio2.project.models.Property;

public interface IPropertyRepository {
    Property findPropertyByName(String propertyName) throws PropertyNameNotFoundException;

    District findDistrictByName(String districtName) throws PropertyDistrictNameNotFoundException;

    void saveProperty(Property property) throws PropertyAlreadyExistsException, PropertyDistrictNameNotFoundException;
}
