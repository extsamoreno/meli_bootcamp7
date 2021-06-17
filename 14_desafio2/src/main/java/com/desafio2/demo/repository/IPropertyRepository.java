package com.desafio2.demo.repository;

import com.desafio2.demo.exception.NeighborhoodNotFoundException;
import com.desafio2.demo.exception.PropertyNotFoundException;
import com.desafio2.demo.model.Neighborhood;
import com.desafio2.demo.model.Property;

public interface IPropertyRepository{
    Property getPropertyById(int propertyId) throws PropertyNotFoundException;
    Neighborhood getNeighborhoodById(String neighborhood) throws NeighborhoodNotFoundException;
}
