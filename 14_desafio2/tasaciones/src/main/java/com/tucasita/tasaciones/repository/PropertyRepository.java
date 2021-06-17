package com.tucasita.tasaciones.repository;

import com.tucasita.tasaciones.exception.NeighborhoodNotFoundException;
import com.tucasita.tasaciones.model.Property;

import java.io.IOException;

public interface PropertyRepository {

    Property getPropertyById(int id);
    void saveProperty(Property property) throws IOException;
}
