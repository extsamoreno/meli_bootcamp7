package com.example.desafio2.repositories;

import com.example.desafio2.exceptions.NeighborhoodAlreadyExistException;
import com.example.desafio2.exceptions.NeighborhoodNotFoundException;
import com.example.desafio2.models.NeighborhoodDTO;

public interface INeighborhoodRepository {

    NeighborhoodDTO saveNeighborhood(NeighborhoodDTO neighborhoodDTO) throws NeighborhoodAlreadyExistException;
    NeighborhoodDTO getNeighborhoodByName(String neighborhood) throws NeighborhoodNotFoundException;
}
