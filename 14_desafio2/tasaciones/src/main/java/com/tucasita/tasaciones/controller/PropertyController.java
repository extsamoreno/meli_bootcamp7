package com.tucasita.tasaciones.controller;

import com.tucasita.tasaciones.dto.PropertyDTO;
import com.tucasita.tasaciones.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.io.IOException;

@RestController
@RequestMapping("/properties")
public class PropertyController {

    @Autowired
    private PropertyService propertyService;

    @PostMapping("/")
    public ResponseEntity<?> saveProperty(@Valid @RequestBody PropertyDTO property) throws IOException {
        propertyService.saveProperty(property);
        return ResponseEntity.ok().build();
    }
}
