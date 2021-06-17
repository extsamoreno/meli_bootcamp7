package com.meli.tucasita.controller;

import com.meli.tucasita.dto.*;
import com.meli.tucasita.service.PropertyService;
import com.meli.tucasita.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

@RestController
public class PropertyController {

  @Autowired
  private PropertyService propertyService;

  // US-0000: Testear validaciones de input
  @PostMapping("/newProperty")
  public ResponseEntity<Map<Integer, PropertyDto>> addNewProperty (@Valid @RequestBody PropertyDto propertyDto) {
    return new ResponseEntity<>(propertyService.addNewProperty(propertyDto), HttpStatus.OK);
  }

  @PostMapping("/newDistrict")
  public ResponseEntity<Map<Integer, DistrictDto>> addNewDistrict (@Valid @RequestBody DistrictDto districtDto) {
    return new ResponseEntity<>(propertyService.addNewDistrict(districtDto), HttpStatus.OK);
  }

  // US-0001: Calcular el total de metros cuadrados de una propiedad
  @GetMapping("/calculateArea/{id}")
  public ResponseEntity<PropertyAreaDto> getPropertyArea(@PathVariable int id) {
    return new ResponseEntity<>(propertyService.getPropertyArea(id), HttpStatus.OK) ;
  }

  // US-0002: Indicar el valor de una propiedad a partir de sus ambientes y medidas
  @GetMapping("/calculatePrice/{id}")
  public ResponseEntity<PropertyPriceDto> getPropertyPrice(@PathVariable int id) {
    return new ResponseEntity<>(propertyService.getPropertyPrice(id), HttpStatus.OK) ;
  }

  // US-0003: Determinar cuál es el ambiente más grande
  @GetMapping("/biggestEnvironment/{id}")
  public ResponseEntity<EnvironmentAreaDto> getBiggestEnvironment(@PathVariable int id) {
    return new ResponseEntity<>(propertyService.getBiggestEnvironment(id), HttpStatus.OK) ;
  }

  // US-0004: Determinar la cantidad de metros cuadrados que tiene cada ambiente de una propiedad
  @GetMapping("/environments/{id}")
  public ResponseEntity<List<EnvironmentAreaDto>> getPropertyEnvironments(@PathVariable int id) {
    return new ResponseEntity<>(propertyService.getPropertyEnvironments(id), HttpStatus.OK) ;
  }
}
