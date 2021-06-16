package com.meli.tucasitatasaciones.controller;

import com.meli.tucasitatasaciones.dto.PropertyDTO;
import com.meli.tucasitatasaciones.service.IPropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

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
}
