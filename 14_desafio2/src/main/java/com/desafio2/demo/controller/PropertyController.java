package com.desafio2.demo.controller;

import com.desafio2.demo.dtos.ResponseBiggestEnvironmentDTO;
import com.desafio2.demo.dtos.ResponsePropertySquareDTO;
import com.desafio2.demo.dtos.ResponsePropertyValueDTO;
import com.desafio2.demo.dtos.ResponseSquareMetersEnvironmentDTO;
import com.desafio2.demo.exception.NeighborhoodAlreadyExistException;
import com.desafio2.demo.exception.PropertyAlreadyExistException;
import com.desafio2.demo.exception.PropertyException;
import com.desafio2.demo.exception.PropertyNotFoundException;
import com.desafio2.demo.model.Neighborhood;
import com.desafio2.demo.model.Property;
import com.desafio2.demo.service.IPropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/properties")
public class PropertyController {

    @Autowired
    IPropertyService iPropertyService;

    @GetMapping("/{propertyId}/squareMeters")
    public ResponseEntity<ResponsePropertySquareDTO> getSquareMeters(@PathVariable int propertyId)
            throws PropertyNotFoundException {
        return new ResponseEntity<>(iPropertyService.getSquareMeters(propertyId), HttpStatus.OK);
    }

    @GetMapping("/{propertyId}/value")
    public ResponseEntity<ResponsePropertyValueDTO> getPropertyValue(@PathVariable int propertyId)
            throws PropertyException {
        return new ResponseEntity<>(iPropertyService.getPropertyValue(propertyId), HttpStatus.OK);
    }

    @GetMapping("/{propertyId}/biggestEnvironment")
    public ResponseEntity<ResponseBiggestEnvironmentDTO> getBiggestEnvironment(@PathVariable int propertyId)
            throws PropertyNotFoundException {
        return new ResponseEntity<>(iPropertyService.getBiggestEnvironment(propertyId), HttpStatus.OK);
    }

    @GetMapping("/{propertyId}/environments/squareMeters")
    public ResponseEntity<ResponseSquareMetersEnvironmentDTO> getSquareMetersOfEnvironments(
            @PathVariable int propertyId)
            throws PropertyNotFoundException {
        return new ResponseEntity<>(iPropertyService.getSquareMetersOfEnvironments(propertyId), HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<Property> createProperty(@Validated @RequestBody Property property)
            throws PropertyAlreadyExistException {
        return new ResponseEntity<>(iPropertyService.createProperty(property), HttpStatus.CREATED);
    }

    @PostMapping("/neighborhood/create")
    public ResponseEntity<Neighborhood> createNeighborhood(@Validated @RequestBody Neighborhood neighborhood)
            throws NeighborhoodAlreadyExistException {
        return new ResponseEntity<>(iPropertyService.createNeighborhood(neighborhood), HttpStatus.CREATED);
    }
}
