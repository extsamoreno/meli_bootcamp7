package com.meli.desafio2.controller;

import com.meli.desafio2.dto.*;
import com.meli.desafio2.service.IPropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

//produces = "application/json;charset=UTF-8"
@RestController
@RequestMapping(value = "/properties")
public class PropertyController {

    @Autowired
    IPropertyService propertyService;

    @PostMapping(value = "/newproperty")
    public ResponseEntity<String> newProperty(@Valid @RequestBody PropertyInputDTO property){
        String message = propertyService.newProperty(property);
        return new ResponseEntity<>(message,HttpStatus.OK);
    }

    @GetMapping(value = "/{id}",produces = "application/json;charset=UTF-8")
    public ResponseEntity<PropertyFullDTO> getProperty(@PathVariable("id") int id) {
        return new ResponseEntity<>(propertyService.getProperty(id),HttpStatus.OK);
    }

    @GetMapping(value = "/squaremeters/{id}", produces = "application/json;charset=UTF-8")
    public ResponseEntity<PropertySquareDTO> getSquareMeters(@PathVariable("id") int id) {
        return new ResponseEntity<>(propertyService.getSquareMeters(id),HttpStatus.OK);
    }

    @GetMapping(value = "/value/{id}", produces = "application/json;charset=UTF-8")
    public ResponseEntity<PropertyValueDTO> getValue(@PathVariable("id") int id) {
        return new ResponseEntity<>(propertyService.getValue(id),HttpStatus.OK);
    }

    @GetMapping(value = "/biggestenvironment/{id}", produces = "application/json;charset=UTF-8")
    public ResponseEntity<PropertyBiggestEnvironmentDTO> getBiggestEnvironment(@PathVariable("id") int id) {
        return new ResponseEntity<>(propertyService.getBiggestEnvironment(id),HttpStatus.OK);
    }

    @GetMapping(value = "/environmentssquare/{id}", produces = "application/json;charset=UTF-8")
    public ResponseEntity<PropertyAllSquareDTO> getEnvironmentsSquare(@PathVariable("id") int id) {
        return new ResponseEntity<>(propertyService.getEnvironmentsSquare(id),HttpStatus.OK);
    }
}
