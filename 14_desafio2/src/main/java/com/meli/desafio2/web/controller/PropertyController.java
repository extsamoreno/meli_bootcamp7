package com.meli.desafio2.web.controller;

import com.meli.desafio2.web.dto.request.PropertyDTO;
import com.meli.desafio2.web.exception.DistrictNotFoundException;
import com.meli.desafio2.web.exception.PropertyAlreadyExistException;
import com.meli.desafio2.web.exception.PropertyNameNotFoundException;
import com.meli.desafio2.web.response.*;
import com.meli.desafio2.web.service.IPropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/property/")
public class PropertyController {
    @Autowired
    IPropertyService iPropertyService;
    @GetMapping("/biggest/{name}")
    public ResponseEntity<BiggestEnvironmentResponse> getBiggestEnvironment(@PathVariable("name") String name) throws PropertyNameNotFoundException {
        return new ResponseEntity<>(iPropertyService.getBiggestEnvironment(name), HttpStatus.OK);
    }

    @GetMapping("/value/{name}")
    public ResponseEntity<PropertyValueResponse> getPropertyValue(@PathVariable("name") String name) throws PropertyNameNotFoundException {
        return new ResponseEntity<>(iPropertyService.getValue(name),HttpStatus.OK);
    }
    @GetMapping("/squaremeters/{name}")
    public ResponseEntity<SquareMetersResponse> getPropertySquareMeters(@PathVariable("name") String name) throws PropertyNameNotFoundException {
        return new ResponseEntity<>(iPropertyService.getSquareMeters(name),HttpStatus.OK);
    }

    @GetMapping("/metersenvironment/{name}")
    public ResponseEntity<SquareMetersEnvironmentResponse> getEnvironmentsSquareMeters(@PathVariable("name") String name) throws PropertyNameNotFoundException {
        return new ResponseEntity<>(iPropertyService.getEnvironmentSquareMeters(name),HttpStatus.OK);
    }
    @PostMapping("/save")
    public ResponseEntity<?> addProperty(@Valid @RequestBody PropertyDTO propertyDTO) throws PropertyAlreadyExistException, DistrictNotFoundException {
        iPropertyService.addProperty(propertyDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }



}
