package com.meli.desafio2.controller;

import com.meli.desafio2.model.Property;
import com.meli.desafio2.model.dto.PropertyDTO;
import com.meli.desafio2.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/property")
public class PropertyController {

    @Autowired
    PropertyService propertyService;

    //Method to save property
    @PostMapping("/save")
    public ResponseEntity saveProperty(@Valid @RequestBody Property prop){
        propertyService.saveProperty(prop);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //US-0001 - Method to calculate mts2 of a Property
    @GetMapping("/calculateMts2")
    public ResponseEntity<PropertyDTO> calculateMts2(){
        PropertyDTO result = propertyService.calculateMts2();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    //US-0002 - Method to calculate price of a Property
    @GetMapping("/calculatePrice")
    public ResponseEntity<PropertyDTO> calculatePrice(){
        PropertyDTO result = propertyService.calculatePrice();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    //US-0003 - Method to calculate most greater environment of a Property
    @GetMapping("/obtainMostGreaterEnvironment")
    public ResponseEntity<PropertyDTO> obtainMostGreaterEnvironment(){
        PropertyDTO result = propertyService.obtainMostGreaterEnvironment();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    //US-0004 - Method to calculate environment mts2 of a Property
    @GetMapping("/calculateEnvironmentMts2")
    public ResponseEntity<PropertyDTO> calculateEnvironmentMts2(){
        PropertyDTO result = propertyService.calculateEnvironmentMts2();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }



}
