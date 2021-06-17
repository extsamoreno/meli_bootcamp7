package com.desafio2.demo.repository;

import com.desafio2.demo.exception.NeighborhoodAlreadyExistException;
import com.desafio2.demo.exception.NeighborhoodNotFoundException;
import com.desafio2.demo.exception.PropertyAlreadyExistException;
import com.desafio2.demo.exception.PropertyNotFoundException;
import com.desafio2.demo.model.Neighborhood;
import com.desafio2.demo.model.Property;

public interface IPropertyRepository{
    Property saveProperty(Property property) throws PropertyAlreadyExistException;
    Neighborhood saveNeighborhood(Neighborhood neighborhood) throws NeighborhoodAlreadyExistException;
    Property getPropertyById(int propertyId) throws PropertyNotFoundException;
    Neighborhood getNeighborhoodById(String neighborhood) throws NeighborhoodNotFoundException;
}
