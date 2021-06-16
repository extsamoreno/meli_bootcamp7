package com.meli.tucasita.repository;

import com.meli.tucasita.exception.PropertyNotFoundException;
import com.meli.tucasita.model.Property;

public interface IPropertyRepository {
    public Property getPropertyByName(String name) throws PropertyNotFoundException;
}
