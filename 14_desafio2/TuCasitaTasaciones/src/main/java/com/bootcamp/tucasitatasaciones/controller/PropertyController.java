package com.bootcamp.tucasitatasaciones.controller;

import com.bootcamp.tucasitatasaciones.DTO.PropertyDTO;
import com.bootcamp.tucasitatasaciones.exception.DistrictNotFoundException;
import com.bootcamp.tucasitatasaciones.service.IPropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    IPropertyService propertyService;

    @PostMapping("register-property")
    public ResponseEntity<?> registerProperty(@Valid @RequestBody PropertyDTO property) throws DistrictNotFoundException {
        propertyService.registerProperty(property);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}
