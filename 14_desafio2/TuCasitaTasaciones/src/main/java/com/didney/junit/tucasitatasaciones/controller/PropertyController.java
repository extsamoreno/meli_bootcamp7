package com.didney.junit.tucasitatasaciones.controller;

import com.didney.junit.tucasitatasaciones.dto.PropertyDTO;
import com.didney.junit.tucasitatasaciones.dto.response.EnvironmentDTOResponse;
import com.didney.junit.tucasitatasaciones.dto.response.TotalSquareMeterByEnvironmentDTOResponse;
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
    IPropertyService ipropertyService;

    public PropertyController(IPropertyService ipropertyService) {
        this.ipropertyService = ipropertyService;
    }

    @GetMapping("/totalsquaremeterproperty/{id}")
    ResponseEntity<TotalSquareMeterPropertyDTOResponse> getTotalSquareMeterProperty(@PathVariable int id) {
        return new ResponseEntity<>(ipropertyService.getTotalSquareMeterProperty(id), HttpStatus.OK);
    }

    @GetMapping("/totalvaluepropertybyenvironment/{id}")
    ResponseEntity<TotalValuePropertyByEnvironmentDTOResponse> getTotalValuePropertyByEnvironment(@PathVariable int id) {
        return new ResponseEntity<>(ipropertyService.getTotalValuePropertyByEnvironment(id), HttpStatus.OK);
    }

    @GetMapping("/biggerenvironment/{id}")
    ResponseEntity<EnvironmentDTOResponse> getBiggerEnvironment(@PathVariable int id) {
        return new ResponseEntity<>(ipropertyService.getBiggerEnvironment(id), HttpStatus.OK);
    }

    @GetMapping("/totalsquearemeterbyenvironment/{id}")
    ResponseEntity<TotalSquareMeterByEnvironmentDTOResponse> getTotalSquareMeterByEnvironment(@PathVariable int id) {
        return new ResponseEntity<>(ipropertyService.getTotalSquareMeterByEnvironment(id), HttpStatus.OK);
    }

    @PostMapping("/add")
    ResponseEntity<PropertyDTO> addProperty(@Valid @RequestBody PropertyDTO propertyDTO) {
        return new ResponseEntity<>(ipropertyService.addProperty(propertyDTO), HttpStatus.OK);
    }

    @PostMapping("/adds")
    ResponseEntity<List<PropertyDTO>> addProperties(@Valid @RequestBody List<PropertyDTO> propertyDTOList) {
        return new ResponseEntity<>(ipropertyService.addProperties(propertyDTOList), HttpStatus.OK);
    }

    @GetMapping("")
    ResponseEntity<List<PropertyDTO>> getProperties() {
        return new ResponseEntity<>(ipropertyService.getPropertiesList(), HttpStatus.OK);
    }
}
