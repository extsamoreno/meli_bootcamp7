package com.tucasita.tasaciones.repository;

import com.tucasita.tasaciones.model.Neighborhood;

public interface NeighborhoodRepository {

    Neighborhood getByName(String name);
}
