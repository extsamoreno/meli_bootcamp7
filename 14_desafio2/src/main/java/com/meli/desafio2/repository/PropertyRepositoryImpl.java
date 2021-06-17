package com.meli.desafio2.repository;

import com.meli.desafio2.model.Property;
import org.springframework.stereotype.Repository;

@Repository
public class PropertyRepositoryImpl implements PropertyRepository{
    Property prop;


    @Override
    public void save(Property prop) {
        this.prop = prop;
    }

    @Override
    public Property getProperty() {
        return prop;
    }
}
