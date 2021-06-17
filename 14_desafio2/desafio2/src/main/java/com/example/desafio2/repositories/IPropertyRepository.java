package com.example.desafio2.repositories;

import com.example.desafio2.exceptions.PropertyAlreadyExistException;
import com.example.desafio2.exceptions.PropertyNotFoundException;
import com.example.desafio2.models.PropertyDTO;

public interface IPropertyRepository {

    PropertyDTO saveProperty(PropertyDTO propertyDTO) throws PropertyAlreadyExistException;
    PropertyDTO getPropertyById(int propertyId) throws PropertyNotFoundException;
}
