package com.desafio2.demo.controller;

import com.desafio2.demo.exception.NeighborhoodAlreadyExistException;
import com.desafio2.demo.model.Neighborhood;
import com.desafio2.demo.service.INeighborhoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class NeighborhoodController {
    @Autowired
    INeighborhoodService neighborhoodService;

    /**
     * Add a neighborhood to db
     */
    @PostMapping("/create")
    public ResponseEntity<Neighborhood> createNeighborhood(@Validated @RequestBody Neighborhood neighborhood)
            throws NeighborhoodAlreadyExistException {
        return new ResponseEntity<>(neighborhoodService.createNeighborhood(neighborhood), HttpStatus.CREATED);
    }

}
