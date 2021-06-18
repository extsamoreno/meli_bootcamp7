package com.example.challenge2.controllers;

import com.example.challenge2.dtos.*;
import com.example.challenge2.exceptions.DistrictNotFoundException;
import com.example.challenge2.models.Property;
import com.example.challenge2.serivces.IPropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/property")
public class PropertyController {

    @Autowired
    IPropertyService propertyService;


    @PostMapping("/record")
    public ResponseEntity<Property> registerProperty(@RequestBody @Valid Property property) throws DistrictNotFoundException {

        return new ResponseEntity<>(this.propertyService.create(property), HttpStatus.CREATED);
    }


    @GetMapping("/getTotalSize/{propertyName}")
    public ResponseEntity<SizeResponseDTO> getSize(@PathVariable String propertyName) {
        return new ResponseEntity<>(this.propertyService.getSize(propertyName), HttpStatus.OK);
    }

    @GetMapping("/getPrice/{propertyName}")
    public ResponseEntity<PriceResponseDTO> getPrice(@PathVariable String propertyName) {
        return new ResponseEntity<>(this.propertyService.getPrice(propertyName), HttpStatus.OK);
    }

    @GetMapping("/getBiggerEnvironment/{propertyName}")
    public ResponseEntity<BiggerEnvironmentResponseDTO> getBiggerEnvironment(@PathVariable String propertyName) {
        return new ResponseEntity<>(this.propertyService.getBiggerEnvironment(propertyName), HttpStatus.OK);
    }

    @GetMapping("/getEnvironmentsSizes/{propertyName}")
    public ResponseEntity<EnvironmentSizesDTO> getEnvironments(@PathVariable String propertyName) {
        return new ResponseEntity<>(this.propertyService.getEnvironments(propertyName), HttpStatus.OK);
    }
}
