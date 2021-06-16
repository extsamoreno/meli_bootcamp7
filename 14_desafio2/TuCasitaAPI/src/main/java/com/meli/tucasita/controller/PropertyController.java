package com.meli.tucasita.controller;

import com.meli.tucasita.exception.PropertyNotFoundException;
import com.meli.tucasita.service.IPropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/property")
public class PropertyController {

    @Autowired
    IPropertyService iPropertyService;

    @GetMapping("/totalM2/{propertyName}")
    public ResponseEntity<?> getTotalM2(@PathVariable String propertyName) throws PropertyNotFoundException {
        return new ResponseEntity<>(iPropertyService.getTotalM2(propertyName), HttpStatus.OK);
    }
}
