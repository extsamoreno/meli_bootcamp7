package com.didney.junit.tucasitatasaciones.controller;

import com.didney.junit.tucasitatasaciones.dto.PropertyDTO;
import com.didney.junit.tucasitatasaciones.dto.response.EnvironmentDTOResponse;
import com.didney.junit.tucasitatasaciones.dto.response.TotalSquareMeterByEnvironmentResponse;
import com.didney.junit.tucasitatasaciones.dto.response.TotalSquareMeterPropertyDTOResponse;
import com.didney.junit.tucasitatasaciones.dto.response.TotalValuePropertyByEnvironmentDTOResponse;
import com.didney.junit.tucasitatasaciones.service.IPropertyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/property")
public class PropertyController {
    IPropertyService propertyService;

    public PropertyController(IPropertyService propertyService) {
        this.propertyService = propertyService;
    }

    @GetMapping("/totalsquaremeterproperty/{id}")
    TotalSquareMeterPropertyDTOResponse getTotalSquareMeterProperty(@PathVariable int id) {
        return propertyService.getTotalSquareMeterProperty(id);
    }

    @GetMapping("/totalvaluepropertybyenvironment/{id}")
    TotalValuePropertyByEnvironmentDTOResponse getTotalValuePropertyByEnvironment(@PathVariable int id) {
        return propertyService.getTotalValuePropertyByEnvironment(id);
    }

    @GetMapping("/biggerenvironment/{id}")
    EnvironmentDTOResponse getBiggerEnvironment(@PathVariable int id) {
        return propertyService.getBiggerEnvironment(id);
    }

    @GetMapping("/totalsquearemeterbyenvironment/{id}")
    TotalSquareMeterByEnvironmentResponse getTotalSquareMeterByEnvironment(@PathVariable int id) {
        return propertyService.getTotalSquareMeterByEnvironment(id);
    }

    @PostMapping("/add")
    ResponseEntity<?> addProperty(@Valid @RequestBody PropertyDTO propertyDTO) {
        return new ResponseEntity<>(propertyService.addProperty(propertyDTO), HttpStatus.OK);
    }

    @PostMapping("/adds")
    ResponseEntity<?> addProperties(@Valid @RequestBody List<PropertyDTO> propertyDTOList) {
        return new ResponseEntity<>(propertyService.addProperties(propertyDTOList), HttpStatus.OK);
    }

    @GetMapping("")
    ResponseEntity<List<PropertyDTO> > getProperties() {
        return new ResponseEntity<>(propertyService.getPropertiesList(), HttpStatus.OK);
    }
}
