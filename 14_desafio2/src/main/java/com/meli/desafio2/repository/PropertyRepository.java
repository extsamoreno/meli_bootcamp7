package com.meli.desafio2.repository;

import com.meli.desafio2.exception.PropertyException;
import com.meli.desafio2.model.Property;

public interface PropertyRepository {
    void save(Property prop);
    Property getProperty() throws PropertyException;

}
