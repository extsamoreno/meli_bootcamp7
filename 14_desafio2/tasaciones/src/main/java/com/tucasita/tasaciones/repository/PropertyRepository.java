package com.tucasita.tasaciones.repository;

import com.tucasita.tasaciones.exception.NeighborhoodNotFoundException;
import com.tucasita.tasaciones.model.Property;

import java.io.IOException;
import java.util.List;

public interface PropertyRepository {

    Property getPropertyById(int id);
    List<Property> getAllProperties();
    void saveProperty(Property property) throws IOException;
}
