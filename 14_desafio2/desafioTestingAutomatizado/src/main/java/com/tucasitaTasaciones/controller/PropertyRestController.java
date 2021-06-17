package com.tucasitaTasaciones.controller;

import com.tucasitaTasaciones.dto.PropertyDTO;
import com.tucasitaTasaciones.service.IPropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class PropertyRestController {

    @Autowired
    IPropertyService propertyService;

    @PostMapping("/newProperty")
    public ResponseEntity<?> addNewProperty(@Valid @RequestBody PropertyDTO property) {
        propertyService.addNewProperty(property);
        return ResponseEntity.ok("Property added successfully! :)");
    }

    @GetMapping("/getProperties")
    public ResponseEntity<List<PropertyDTO>> getAllProperties() {
        return new ResponseEntity(propertyService.getProperties(), HttpStatus.OK);
    }

}
