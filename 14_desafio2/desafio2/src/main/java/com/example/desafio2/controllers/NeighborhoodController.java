package com.example.desafio2.controllers;

import com.example.desafio2.exceptions.NeighborhoodAlreadyExistException;
import com.example.desafio2.models.NeighborhoodDTO;
import com.example.desafio2.services.INeighborhoodService;
import com.example.desafio2.services.IPropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/properties/neighborhood")
public class NeighborhoodController {

    @Autowired
    INeighborhoodService neighborhoodService;

    /**
     * Add a neighborhood to the database
     * @param neighborhoodDTO neighborhood to add to database
     * @return NeighborhoodDTO that contains the neighborhood
     * Response
     * 200 -> OK
     * @throws NeighborhoodAlreadyExistException if there is already a neighborhood with that name
     * Example: localhost:8081/properties/neighborhood/create
     * {
     *     "name": "Avellaneda Uno",
     *     "price": 1200.00
     * }
     * @author Sapaya Nicolás Martín
     */
    @PostMapping("/create")
    public ResponseEntity<NeighborhoodDTO> createNeighborhood(@Valid @RequestBody NeighborhoodDTO neighborhoodDTO)
            throws NeighborhoodAlreadyExistException {
        return new ResponseEntity<>(neighborhoodService.createNeighborhood(neighborhoodDTO), HttpStatus.CREATED);
    }
}
