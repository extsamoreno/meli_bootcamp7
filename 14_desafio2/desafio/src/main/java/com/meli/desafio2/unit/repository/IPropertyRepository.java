package com.meli.desafio2.unit.repository;

import com.meli.desafio2.model.Property;

public interface IPropertyRepository {


    void create(Property property);

    Property fetch(Long id);

    Double fetch(String name);
}
