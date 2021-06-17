package com.example.desafio2.repositories;

import com.example.desafio2.exceptions.NeighborhoodNotFoundException;
import com.example.desafio2.exceptions.PropertyNotFoundException;
import com.example.desafio2.models.NeighborhoodDTO;
import com.example.desafio2.models.PropertyDTO;

public interface IPropertyRepository {

    PropertyDTO getPropertyById(int propertyId) throws PropertyNotFoundException;
    NeighborhoodDTO getNeighborhoodById(String neighborhood) throws NeighborhoodNotFoundException;
}
