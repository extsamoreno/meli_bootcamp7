package com.bootcamp.desafio2.controller;

import com.bootcamp.desafio2.dto.PropertyDTO;
import com.bootcamp.desafio2.service.IPropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/properties")
public class PropertyController {

    @Autowired
    private IPropertyService propertyService;

    // US-0001
    @GetMapping("/features/{prop_name}")
    public ResponseEntity<PropertyDTO> calculateFeatures(@PathVariable String prop_name) {
        PropertyDTO propertyDTO = propertyService.calculateFeatures (prop_name);
        return new ResponseEntity(propertyDTO, HttpStatus.OK);
    }
}
