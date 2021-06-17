package com.example.challenge_2.controller;

import com.example.challenge_2.exception.DistrictException;
import com.example.challenge_2.exception.PropertyException;
import com.example.challenge_2.service.IPropertyService;
import com.example.challenge_2.service.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/property")
public class PropertyController {

    @Autowired
    IPropertyService propertyService;

    @PostMapping("")
    public ResponseEntity<NewIdDTO> createProperty(@Valid @RequestBody PropertyDTO property) throws DistrictException {
        return new ResponseEntity<NewIdDTO>(propertyService.createProperty(property), HttpStatus.OK);
    }

    @GetMapping("/get-square-meters/{propertyId}")
    public ResponseEntity<SquareMetersDTO> getSquareMeters(@PathVariable int propertyId) throws PropertyException {
        return new ResponseEntity<SquareMetersDTO>(propertyService.getSquareMeters(propertyId), HttpStatus.OK);
    }

    @GetMapping("/get-property-price/{propertyId}")
    public ResponseEntity<PropertyPriceDTO> getPropertyPrice(@PathVariable int propertyId) throws PropertyException {
        return new ResponseEntity<PropertyPriceDTO>(propertyService.getPropertyPrice(propertyId), HttpStatus.OK);
    }

    @GetMapping("/get-biggest-environment/{propertyId}")
    public ResponseEntity<EnvironmentDTO> getBiggestEnvironment(@PathVariable int propertyId) throws PropertyException {
        return new ResponseEntity<EnvironmentDTO>(propertyService.getBiggestEnvironment(propertyId), HttpStatus.OK);
    }

    @GetMapping("/get-square-meters-each-environment/{propertyId}")
    public ResponseEntity<List<EnvironmentSquareMetersDTO>> getSquareMetersEachEnvironment(@PathVariable int propertyId) throws PropertyException {
        return new ResponseEntity<List<EnvironmentSquareMetersDTO>>(propertyService.getSquareMetersEachEnvironment(propertyId), HttpStatus.OK);
    }
}
