package com.desafio2.demo.service;

import com.desafio2.demo.exception.NeighborhoodAlreadyExistException;
import com.desafio2.demo.model.Neighborhood;
import com.desafio2.demo.repository.INeighborhoodRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class NeighborhoodService implements INeighborhoodService {

    @Autowired
    INeighborhoodRepository neighborhoodRepository;

    @Override
    public Neighborhood createNeighborhood(Neighborhood neighborhood)
            throws NeighborhoodAlreadyExistException {
        return neighborhoodRepository.saveNeighborhood(neighborhood);
    }
}
