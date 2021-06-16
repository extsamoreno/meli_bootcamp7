package com.tucasitatasaciones.demo.controller;

import com.tucasitatasaciones.demo.dto.PropertyDTO;
import com.tucasitatasaciones.demo.exception.ResponseException;
import com.tucasitatasaciones.demo.service.IPropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("api/properties")
public class PropertyController {

    @Autowired
    private IPropertyService propertyService;

    @PostMapping("/new")
    public ResponseEntity<PropertyDTO> postProperty(@RequestBody @Valid PropertyDTO property) {
        return ResponseEntity.ok(propertyService.addProperty(property));
    }

}
