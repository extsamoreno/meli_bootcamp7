package com.meli.desafio2.controller;

import com.meli.desafio2.dto.*;
import com.meli.desafio2.exception.PropertyNotFoundException;
import com.meli.desafio2.service.IPropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

//produces = "application/json;charset=UTF-8"
@RestController
@RequestMapping(value = "/properties")
public class PopertyController {

    @Autowired
    IPropertyService propertyService;

    @PostMapping(value = "/newpropierty")
    public ResponseEntity<String> newProperty(@Valid @RequestBody PropertyInputDTO property){
        int id = propertyService.newProperty(property);
        return new ResponseEntity<>("The property has been added succesfully with the ID: "+id,HttpStatus.OK);
    }

    @GetMapping(value = "/{id}",produces = "application/json;charset=UTF-8")
    public ResponseEntity<PropertyFullDTO> getProperty(@PathVariable("id") int id) throws PropertyNotFoundException {
        return new ResponseEntity<>(propertyService.getProperty(id),HttpStatus.OK);
    }

    @GetMapping(value = "/squaremeters/{id}", produces = "application/json;charset=UTF-8")
    public ResponseEntity<PropertySquareDTO> getSquareMeters(@PathVariable("id") int id) throws PropertyNotFoundException {
        return new ResponseEntity<>(propertyService.getSquareMeters(id),HttpStatus.OK);
    }

    @GetMapping(value = "/value/{id}", produces = "application/json;charset=UTF-8")
    public ResponseEntity<PropertyValueDTO> getValue(@PathVariable("id") int id) throws PropertyNotFoundException {
        return new ResponseEntity<>(propertyService.getValue(id),HttpStatus.OK);
    }

    @GetMapping(value = "/biggestenviroment/{id}", produces = "application/json;charset=UTF-8")
    public ResponseEntity<PropertyBiggestEnviromentDTO> getBiggestEnviroment(@PathVariable("id") int id) throws PropertyNotFoundException {
        return new ResponseEntity<>(propertyService.getBiggestEnviroment(id),HttpStatus.OK);
    }

    @GetMapping(value = "/enviromentssquare/{id}", produces = "application/json;charset=UTF-8")
    public ResponseEntity<PropertyAllSquareDTO> getEnviromentsSquare(@PathVariable("id") int id) throws PropertyNotFoundException {
        return new ResponseEntity<>(propertyService.getEnviromentsSquare(id),HttpStatus.OK);
    }
}
