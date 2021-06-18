package com.testingchallenge.tucasita.repository;

import com.testingchallenge.tucasita.exception.PropertyNotFoundException;
import com.testingchallenge.tucasita.model.Property;
import org.springframework.http.HttpStatus;

public interface iPropertyRepository {
    public Property getByName (String name) throws PropertyNotFoundException;
    public HttpStatus addProperty(Property property);
}
