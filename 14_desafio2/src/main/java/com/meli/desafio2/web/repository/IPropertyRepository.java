package com.meli.desafio2.web.repository;

import com.meli.desafio2.web.model.Environment;
import com.meli.desafio2.web.model.Property;

import java.util.List;

public interface IPropertyRepository {
    public Property getPropertyByName(String name);
    public void saveProperty(Property property);
}
