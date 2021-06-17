package com.meli.tucasita.repository;

import com.meli.tucasita.exception.PropertyNotFoundException;
import com.meli.tucasita.model.Property;
import org.springframework.http.HttpStatus;

public interface IPropertyRepository {
    public Property getPropertyByName(String name) throws PropertyNotFoundException;
    public HttpStatus addNewProperty(Property property);
}
