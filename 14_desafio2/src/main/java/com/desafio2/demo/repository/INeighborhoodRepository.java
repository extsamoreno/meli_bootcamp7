package com.desafio2.demo.repository;

import com.desafio2.demo.exception.NeighborhoodAlreadyExistException;
import com.desafio2.demo.exception.NeighborhoodNotFoundException;
import com.desafio2.demo.model.Neighborhood;

public interface INeighborhoodRepository {

    Neighborhood saveNeighborhood(Neighborhood neighborhood) throws NeighborhoodAlreadyExistException;
    Neighborhood getNeighborhoodByName(String neighborhoods) throws NeighborhoodNotFoundException;
}