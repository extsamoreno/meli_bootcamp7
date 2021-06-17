package com.example.demo.controller;


import com.example.demo.DTO.PropertyDTO;
import com.example.demo.exception.DistrictNotFoundException;
import com.example.demo.services.IPropertyServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class PropertyController {

    @Autowired
    IPropertyServices propertyServices;


    @GetMapping("/getSquareMeter/{id}")
    public ResponseEntity<PropertyDTO> calculateSquareMeter(@PathVariable int id){
        return new ResponseEntity<>(propertyServices.calculateSquareMeter(id), HttpStatus.OK);
    }

    @GetMapping("/getPrice/{id}")
    public ResponseEntity<PropertyDTO> calculatePrice(@PathVariable int id){
        return new ResponseEntity<>(propertyServices.calculatePrice(id), HttpStatus.OK);
    }

    @GetMapping("/getBigger")
    public ResponseEntity<PropertyDTO> calculateBigger(){
        return new ResponseEntity<>(propertyServices.calculateBigger(), HttpStatus.OK);
    }

    @GetMapping("/getSquareMeterByEnvironment/{id}")
    public ResponseEntity<PropertyDTO> calculateSquareMeterByEnvironment(@PathVariable Integer id){
        return new ResponseEntity<>(propertyServices.calculateSquareMeterByEnvironment(id), HttpStatus.OK);
    }

    @PostMapping("/addProperty")
    public ResponseEntity<Void> addProperty(@Valid @RequestBody PropertyDTO property) throws DistrictNotFoundException {
        propertyServices.addProperty(property);
        return new ResponseEntity(HttpStatus.OK);
    }
}
