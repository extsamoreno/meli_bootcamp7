package com.desafio2.demo.controller;

import com.desafio2.demo.dtos.*;
import com.desafio2.demo.exception.DistrictAlreadyExistException;
import com.desafio2.demo.exception.PropertyAlreadyExistException;
import com.desafio2.demo.exception.PropertyException;
import com.desafio2.demo.exception.PropertyNotFoundException;
import com.desafio2.demo.model.District;
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


    @GetMapping("/{propertyId}/value")
    public ResponseEntity<PropertyPriceDTO> getPropertyPrice(@PathVariable int propertyId)
            throws PropertyException {
        return new ResponseEntity<>(iPropertyService.getPropertyPrice(propertyId), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Property> createProperty(@Validated @RequestBody Property property)
            throws PropertyAlreadyExistException {
        return new ResponseEntity<>(iPropertyService.createProperty(property), HttpStatus.CREATED);
    }

    @PostMapping("/district/create")
    public ResponseEntity<District> createDistrict(@Validated @RequestBody District district)
            throws DistrictAlreadyExistException {
        return new ResponseEntity<>(iPropertyService.createDistrict(district), HttpStatus.CREATED);
    }
}
