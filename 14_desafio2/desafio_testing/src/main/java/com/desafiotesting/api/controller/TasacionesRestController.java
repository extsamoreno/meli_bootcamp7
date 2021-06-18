package com.desafiotesting.api.controller;

import com.desafiotesting.api.dto.*;
import com.desafiotesting.api.service.ITasacionesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
public class TasacionesRestController {

    @Autowired
    ITasacionesService services;

    //US 0001: Get total area of a house
    @PostMapping("/totalArea")
    public ResponseEntity<TotalAreaDTO> totalArea(@Valid @RequestBody PropertyDTO house) throws Exception {
        return new ResponseEntity<>(services.totalArea(house), HttpStatus.OK);
    }

    //US 0002: Get price of a house
    @PostMapping("/price")
    public ResponseEntity<PriceDTO> price(@Valid @RequestBody PropertyDTO house) throws Exception {
        return new ResponseEntity<>(services.price(house), HttpStatus.OK);
    }

    //US 0003: Get bigger environment of a house
    @PostMapping("/biggerEnvironment")
    public ResponseEntity<BiggerEnvironmentDTO> biggerEnvironment(@Valid @RequestBody PropertyDTO house) throws Exception {
        return new ResponseEntity<>(services.biggerEnvironment(house), HttpStatus.OK);
    }

    //US 0004: Get each environment area of a house
    @PostMapping("/environmentsArea")
    public ResponseEntity<ArrayList<EnvironmentAreaDTO>> environmentsArea(@Valid @RequestBody PropertyDTO house) throws Exception {
        return new ResponseEntity<>(services.environmentsArea(house), HttpStatus.OK);
    }

    //Add a new District to Repository
    @PostMapping("/newDistrict")
    public ResponseEntity<String> newDistrict (@Valid @RequestBody DistrictDTO district) throws Exception {
        return new ResponseEntity<>(services.newDistrict(district), HttpStatus.OK);
    }

}
