package com.meli.tucasitatasaciones.controller;

import com.meli.tucasitatasaciones.dto.PropertyDTO;
import com.meli.tucasitatasaciones.service.property.IPropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/properties")
public class PropertyController {

    @Autowired
    IPropertyService iPropertyService;

    @PostMapping("/newProperty")
    public ResponseEntity<?> registerNewProperty(@RequestBody @Valid PropertyDTO propertyDTO) {
        iPropertyService.createProperty(propertyDTO);
        return ResponseEntity.ok("Propiedad agregada correctamente");
    }

    @GetMapping("/getAllProperties")
    public ResponseEntity<List<PropertyDTO>> getAllProperties() {
        return new ResponseEntity<>(iPropertyService.getAllProperties(), HttpStatus.OK);
    }
}
