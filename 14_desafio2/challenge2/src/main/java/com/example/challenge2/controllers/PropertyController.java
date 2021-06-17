package com.example.challenge2.controllers;

import com.example.challenge2.dtos.*;
import com.example.challenge2.models.District;
import com.example.challenge2.repositories.IPropertyDAO;
import com.example.challenge2.serivces.IPropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/property")
public class PropertyController {

    @Autowired
    IPropertyService propertyService;


    @PostMapping("/registerProperty")
    public ResponseEntity<?> registerStudent(@RequestBody @Valid PropertyDTO property) {
        this.propertyService.create(property);
        return ResponseEntity.ok(null);
    }


    @PostMapping("/registerDistrict")
    public ResponseEntity<?> registerDistrict(@RequestBody @Valid District district) {
        this.propertyService.createDistrict(district);
        return ResponseEntity.ok(null);
    }

    @GetMapping("/getTotalSize/{propertyName}")
    public SizeResponseDTO getSize(@PathVariable String propertyName) {
        return this.propertyService.getSize(propertyName);
    }

    @GetMapping("/getPrice/{propertyName}")
    public PriceResponseDTO getPrice(@PathVariable String propertyName) {
        return this.propertyService.getPrice(propertyName);
    }

    @GetMapping("/getBiggerEnvironment/{propertyName}")
    public BiggerEnvironmentResponseDTO getBiggerEnvironment(@PathVariable String propertyName) {
        return this.propertyService.getBiggerEnvironment(propertyName);
    }

    @GetMapping("/getEnviromentsSizes/{propertyName}")
    public EnvironmentSizesDTO getEnvironments(@PathVariable String propertyName) {
        return this.propertyService.getEnvironments(propertyName);
    }


}
