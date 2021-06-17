package com.example.testing.controller;

import com.example.testing.model.Property;
import com.example.testing.services.IPropertiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class PropertyController {

    @Autowired
    IPropertiesService propertyService;

    @PostMapping("/createProperty")
    public ResponseEntity<?> createProperty(@RequestBody @Valid Property p){
        propertyService.createProperty(p);
        return ResponseEntity.ok(null);
    }

    @GetMapping("/totalSquareMeters/{id}")
    public ResponseEntity<?> getTotalSquareMeters(@PathVariable int id){
        return new ResponseEntity<>(propertyService.totalSquareMeters(id), HttpStatus.OK);
    }

    @GetMapping("/price/{id}")
    public ResponseEntity<?> getPrice(@PathVariable int id){
        return new ResponseEntity<>(propertyService.getPrice(id), HttpStatus.OK);
    }

    @GetMapping("/environment/{id}")
    public ResponseEntity<?> getBiggestEnvironment(@PathVariable int id){
        return new ResponseEntity<>(propertyService.getBiggestEnvironment(id), HttpStatus.OK);
    }

    @GetMapping("/environmentsSquareMeters/{id}")
    public ResponseEntity<?> getEnvironmentSquareMeters(@PathVariable int id){
        return new ResponseEntity<>(propertyService.getEnvironments(id), HttpStatus.OK);
    }

}
