package com.meli.desafio2.web.repository;

import com.meli.desafio2.web.model.District;
import com.meli.desafio2.web.model.Environment;
import com.meli.desafio2.web.model.Property;
import com.meli.desafio2.web.responses.PropertyValueResponse;

import java.util.List;

public interface IPropertyRepository {
    public Property getPropertyByName(String name);
    public List<Environment> getEnvironmentsByPropertyByName(String name);
    public void saveProperty(Property property);
}
