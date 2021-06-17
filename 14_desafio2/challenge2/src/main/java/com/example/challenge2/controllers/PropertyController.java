package com.example.challenge2.controllers;

import com.example.challenge2.dtos.*;
import com.example.challenge2.models.District;
import com.example.challenge2.repositories.IPropertyDAO;
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
    public ResponseEntity<PropertyDTO> registerProperty(@RequestBody @Valid PropertyDTO property) {

        return new ResponseEntity<>(this.propertyService.create(property), HttpStatus.CREATED);
    }


    @PostMapping("/registerDistrict")
    public ResponseEntity<District> registerDistrict(@RequestBody @Valid District district) {
        this.propertyService.createDistrict(district);
        return ResponseEntity.ok(null);
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

    @GetMapping("/getEnviromentsSizes/{propertyName}")
    public ResponseEntity<EnvironmentSizesDTO> getEnvironments(@PathVariable String propertyName) {
        return new ResponseEntity<>(this.propertyService.getEnvironments(propertyName), HttpStatus.OK);
    }


}
