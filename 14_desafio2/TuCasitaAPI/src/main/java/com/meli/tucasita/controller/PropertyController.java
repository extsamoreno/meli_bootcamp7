package com.meli.tucasita.controller;

import com.meli.tucasita.exception.DistrictNotFoundException;
import com.meli.tucasita.exception.PropertyNotFoundException;
import com.meli.tucasita.service.IPropertyService;
import com.meli.tucasita.service.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController()
@RequestMapping("/property")
public class PropertyController {

    @Autowired
    IPropertyService iPropertyService;

    @PostMapping("/add")
    public ResponseEntity<HttpStatus> addNewProperty(@RequestBody @Valid PropertyDTORequest property) throws DistrictNotFoundException {
        HttpStatus status= iPropertyService.addNewProperty(property);
        return new ResponseEntity<>(status, status);
    }

    @GetMapping("/totalM2/{propertyName}")
    public ResponseEntity<PropertyWithM2DTO> getTotalM2(@PathVariable String propertyName) throws PropertyNotFoundException {
        return new ResponseEntity<>(iPropertyService.getTotalM2(propertyName), HttpStatus.OK);
    }

    @GetMapping("/price/{propertyName}")
    public ResponseEntity<PropertyWithPriceDTO> getPrice(@PathVariable String propertyName) throws PropertyNotFoundException {
        return new ResponseEntity<>(iPropertyService.getPrice(propertyName),HttpStatus.OK);
    }

    @GetMapping("/bigger_env/{propertyName}")
    public ResponseEntity<PropertyWithBiggerEnvDTO> getBiggerEnvironment(@PathVariable String propertyName) throws PropertyNotFoundException {
        return new ResponseEntity<>(iPropertyService.getBiggerEnvironment(propertyName),HttpStatus.OK);
    }

    @GetMapping("/meters_per_environment/{propertyName}")
    public ResponseEntity<PropertyWithEnvAndMetersDTO> getMetersPerEnvironment(@PathVariable String propertyName) throws PropertyNotFoundException {
        return new ResponseEntity<PropertyWithEnvAndMetersDTO>(iPropertyService.getMetersPerEnvironment(propertyName),HttpStatus.OK);
    }
}
