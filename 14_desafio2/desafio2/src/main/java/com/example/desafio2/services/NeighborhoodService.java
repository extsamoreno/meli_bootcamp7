package com.example.desafio2.services;

import com.example.desafio2.exceptions.NeighborhoodAlreadyExistException;
import com.example.desafio2.models.NeighborhoodDTO;
import com.example.desafio2.repositories.INeighborhoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NeighborhoodService implements INeighborhoodService {

    @Autowired
    INeighborhoodRepository neighborhoodRepository;

    @Override
    public NeighborhoodDTO createNeighborhood(NeighborhoodDTO neighborhoodDTO)
            throws NeighborhoodAlreadyExistException {
        return neighborhoodRepository.saveNeighborhood(neighborhoodDTO);
    }
}
