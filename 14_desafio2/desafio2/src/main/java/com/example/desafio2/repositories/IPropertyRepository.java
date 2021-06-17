package com.example.desafio2.repositories;

import com.example.desafio2.exceptions.NeighborhoodAlreadyExistException;
import com.example.desafio2.exceptions.NeighborhoodNotFoundException;
import com.example.desafio2.exceptions.PropertyAlreadyExistException;
import com.example.desafio2.exceptions.PropertyNotFoundException;
import com.example.desafio2.models.NeighborhoodDTO;
import com.example.desafio2.models.PropertyDTO;

public interface IPropertyRepository {

    PropertyDTO saveProperty(PropertyDTO propertyDTO) throws PropertyAlreadyExistException;
    NeighborhoodDTO saveNeighborhood(NeighborhoodDTO neighborhoodDTO) throws NeighborhoodAlreadyExistException;
    PropertyDTO getPropertyById(int propertyId) throws PropertyNotFoundException;
    NeighborhoodDTO getNeighborhoodByName(String neighborhood) throws NeighborhoodNotFoundException;
}
