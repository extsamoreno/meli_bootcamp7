package meli.bootcamp.tucasita.repository;

import meli.bootcamp.tucasita.exception.PropertyNotFoundException;
import meli.bootcamp.tucasita.model.Property;

public interface IPropertyRepository {
    Property findById(String name) throws PropertyNotFoundException;

    void save(Property toProperty);

    boolean delete(String name);
}
