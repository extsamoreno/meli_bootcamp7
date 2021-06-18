package com.desafio2.demo.service;

import com.desafio2.demo.exception.NeighborhoodAlreadyExistException;
import com.desafio2.demo.model.Neighborhood;

public interface INeighborhoodService {
    Neighborhood createNeighborhood(Neighborhood neighborhood)
            throws NeighborhoodAlreadyExistException;
}
