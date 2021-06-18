package com.testingchallenge.tucasita.repository;

import com.testingchallenge.tucasita.exception.NeighborhoodNotFoundException;
import com.testingchallenge.tucasita.model.Neighborhood;

public interface iNeighborhoodRepository {
    public Neighborhood getByName (String name) throws NeighborhoodNotFoundException;
}
