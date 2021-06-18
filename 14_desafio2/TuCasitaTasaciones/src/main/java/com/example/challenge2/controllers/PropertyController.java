package com.example.challenge2.controllers;

import com.example.challenge2.dtos.*;
import com.example.challenge2.service.IPropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.el.PropertyNotFoundException;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/property")
public class PropertyController {

    @Autowired
    IPropertyService iPropertyService;

    @GetMapping("/totalAreaDTO")
    public ResponseEntity<Double> getSquareMeters(@PathVariable int id) throws PropertyNotFoundException {
        return ResponseEntity.ok(propertyService.calculateSquareMeters(id));
    }

    @GetMapping("/price")
    public ResponseEntity<Double> getPropertyPrice(@PathVariable int id) throws PropertyNotFoundException {
        return ResponseEntity.ok(propertyService.getPropertyPrice(id));
    }


    @GetMapping ("/biggestEnvironment")
    public ResponseEntity<BiggestEnvironmentDTO> getBiggestEnvironment(@Valid @RequestBody PropertyDTO house) throws Exception {
        return new ResponseEntity<>(service.biggestEnvironment(house), HttpStatus.OK);
    }

    @GetMapping("/environment/{id}")
    public ResponseEntity<List<EnvironmentDTO>> getPropertyEnvironment(@PathVariable int id) {
        return new ResponseEntity<>(propertyService.getPropertyEnvironment(id), HttpStatus.OK) ;
    }
}
