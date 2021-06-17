package com.desafiotesting.desafiotesting.controllers;
import com.desafiotesting.desafiotesting.services.dtos.PropertyDTO;
import com.desafiotesting.desafiotesting.services.IPropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/property")
public class PropertyController {

    @Autowired
    IPropertyService propertyService;

    @PostMapping("/registerproperty")
    public ResponseEntity<?> registerProperty(@RequestBody @Valid PropertyDTO propertyDTO){
        this.propertyService.create(propertyDTO);
        return ResponseEntity.ok(null);
    }

    @PostMapping("/totalsquaremeters/{id}")
    public double totalSquareMeters(@PathVariable int id){
        return propertyService.totalSquareMeters(id);
    }


}
