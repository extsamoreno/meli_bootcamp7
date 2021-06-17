package com.example.desafio2.services;

import com.example.desafio2.exceptions.NeighborhoodAlreadyExistException;
import com.example.desafio2.models.NeighborhoodDTO;

public interface INeighborhoodService {

    NeighborhoodDTO createNeighborhood(NeighborhoodDTO neighborhoodDTO) throws NeighborhoodAlreadyExistException;
}
