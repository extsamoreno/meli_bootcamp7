package com.meli.desafio2.repository;

import com.meli.desafio2.exception.PropertyIdNotFoundException;
import com.meli.desafio2.model.Property;

public interface IPropertyRepository {

    Property getPropertybyId(Integer propId) throws PropertyIdNotFoundException;

}
