package com.TuCasitaTasacionesAPI.TuCasita.controllers;

import com.TuCasitaTasacionesAPI.TuCasita.dtos.*;
import com.TuCasitaTasacionesAPI.TuCasita.exceptions.district.DistrictNotFoundException;
import com.TuCasitaTasacionesAPI.TuCasita.exceptions.property.PropertyAlreadyExistsException;
import com.TuCasitaTasacionesAPI.TuCasita.exceptions.property.PropertyNotFoundException;
import com.TuCasitaTasacionesAPI.TuCasita.services.IPropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/property")
public class PropertyController {

    @Autowired
    IPropertyService iPropertyService;

    @PostMapping("/create")
    public ResponseEntity<Integer> create(@Valid @RequestBody PropertyDTO propertyDTO)
            throws PropertyAlreadyExistsException, DistrictNotFoundException {
        return new ResponseEntity<>(iPropertyService.create(propertyDTO), HttpStatus.CREATED);
    }

    /* solo prueba
    @GetMapping("/getbyid/{idProperty}")
    public ResponseEntity<PropertyDTO> getById(@PathVariable int idProperty) throws PropertyNotFoundException {
        return new ResponseEntity<>(iPropertyService.getById(idProperty), HttpStatus.OK);
    }*/

    //US0001
    @GetMapping("/m2/{idProperty}")
    public ResponseEntity<TotalM2DTO> calculateM2(@PathVariable int idProperty) throws PropertyNotFoundException {
        return new ResponseEntity<>(iPropertyService.calculateM2(idProperty), HttpStatus.OK);
    }

    //US0002
    @GetMapping("/price/{idProperty}")
    public ResponseEntity<PricePropertyDTO> calculatePrice(@PathVariable int idProperty)
            throws PropertyNotFoundException, DistrictNotFoundException {
        return new ResponseEntity<>(iPropertyService.calculatePrice(idProperty), HttpStatus.OK);
    }

    //US0003
    @GetMapping("/environment/biggest/{idProperty}")
    public ResponseEntity<EnvironmentBiggestDTO> environmentBiggest(@PathVariable int idProperty) throws PropertyNotFoundException {
        return new ResponseEntity<>(iPropertyService.environmentBiggest(idProperty), HttpStatus.OK);
    }

    //US0004
    @GetMapping("/environments/m2/{idProperty}")
    public ResponseEntity<M2perEnvironmentsDTO> m2perEnvironments(@PathVariable int idProperty) throws PropertyNotFoundException {
        return new ResponseEntity<>(iPropertyService.m2perEnvironments(idProperty), HttpStatus.OK);
    }
}
