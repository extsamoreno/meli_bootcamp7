package com.meli.desafio2.repository;

import com.meli.desafio2.exception.DistrictIdNotFoundException;
import com.meli.desafio2.exception.PropertyIdAlreadyExistException;
import com.meli.desafio2.exception.PropertyIdNotFoundException;
import com.meli.desafio2.model.Property;

public interface IPropertyRepository {

    Property getPropertybyId(Integer propId) throws PropertyIdNotFoundException;
    void createProperty(Property prop) throws PropertyIdAlreadyExistException, DistrictIdNotFoundException;

}