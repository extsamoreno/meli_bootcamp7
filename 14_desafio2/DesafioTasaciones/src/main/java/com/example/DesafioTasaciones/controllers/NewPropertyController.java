package com.example.DesafioTasaciones.controllers;

import com.example.DesafioTasaciones.dtos.PropertyDTO;
import com.example.DesafioTasaciones.services.IPropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/properties")
public class NewPropertyController {

    @Autowired
    IPropertyService iPropertyService;

    @PostMapping("/newProperty")
    public ResponseEntity<?> registerNewProperty(@RequestBody @Valid PropertyDTO propertyDTO) {
        iPropertyService.createProperty(propertyDTO);
        return ResponseEntity.ok("Property Added correctly");
    }

    @GetMapping("/getAllProperties")
    public ResponseEntity<List<PropertyDTO>> getAllProperties() {
        return new ResponseEntity<>(iPropertyService.getAllProperties(), HttpStatus.OK);
    }
}
