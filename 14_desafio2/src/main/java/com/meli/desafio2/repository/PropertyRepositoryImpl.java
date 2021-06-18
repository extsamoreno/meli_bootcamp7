package com.meli.desafio2.repository;

import com.meli.desafio2.exception.PropertyException;
import com.meli.desafio2.model.Property;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

@Repository
public class PropertyRepositoryImpl implements PropertyRepository{
    Property prop;


    @Override
    public void save(Property prop) {
        this.prop = prop;
    }

    @Override
    public Property getProperty() throws PropertyException {

        if(prop == null){
            throw new PropertyException("Property not found", HttpStatus.NOT_FOUND);
        }

        return prop;
    }
}
