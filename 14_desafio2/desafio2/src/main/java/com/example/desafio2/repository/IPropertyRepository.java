package com.example.desafio2.repository;

import com.example.desafio2.exception.NeighborhoodExceptionNotFound;
import com.example.desafio2.exception.PropertyExceptionNotFound;
import com.example.desafio2.model.Neighborhood;
import com.example.desafio2.model.Property;

import java.util.List;

public interface IPropertyRepository {
    Property findPropertyByName(String name) throws PropertyExceptionNotFound;
    Neighborhood findNeighborhoodByName(String name) throws NeighborhoodExceptionNotFound;
    List<Neighborhood> getNeighborhood();
    List<Property> getProperties();
}
