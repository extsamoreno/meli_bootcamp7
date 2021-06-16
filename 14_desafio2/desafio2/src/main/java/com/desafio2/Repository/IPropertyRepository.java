package com.desafio2.Repository;

import com.desafio2.Model.Property;

public interface IPropertyRepository {
    void save(Property property);
    boolean delete(String name);
    boolean exists(Property property);
    Property findByName(String name);
}
