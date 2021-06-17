package com.tucasitatasaciones.demo.controller;

import com.tucasitatasaciones.demo.dto.*;
import com.tucasitatasaciones.demo.exception.BadRequestException;
import com.tucasitatasaciones.demo.service.IPropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/properties")
public class PropertyController {

    @Autowired
    private IPropertyService propertyService;

    @PostMapping("/new")
    public ResponseEntity<PropertyDTO> postProperty(@RequestBody @Valid PropertyDTO property) throws BadRequestException {
        return ResponseEntity.ok(propertyService.addProperty(property));
    }

    @GetMapping("/{id}/square-metters")
    public ResponseEntity<PropertySquareMettersDTO> getSquareMettersById(@PathVariable int id) throws BadRequestException {
        return ResponseEntity.ok(propertyService.calculateSquareMettersById(id));
    }

    @GetMapping("/{id}/value")
    public ResponseEntity<PropertyPriceDTO> getPropertyPriceById(@PathVariable int id) throws BadRequestException{
        return ResponseEntity.ok(propertyService.calculatePropertyPriceById(id));
    }

    @GetMapping("/{id}/biggest-room")
    public ResponseEntity<PropertyBiggestEnvironmentDTO> getBiggestEnvironmentById(@PathVariable int id) throws BadRequestException{
        return ResponseEntity.ok(propertyService.calculateBiggestEnvironmentById(id));
    }

    @GetMapping("/{id}/environments-square-metters")
    public ResponseEntity<PropertyEnvironmentSquareMetterDTO> getPropertyEnvironmentsSquareMetters(@PathVariable int id) throws BadRequestException{
        return ResponseEntity.ok(propertyService.calculateSquareMettersEnvironmentsById(id));
    }
}
