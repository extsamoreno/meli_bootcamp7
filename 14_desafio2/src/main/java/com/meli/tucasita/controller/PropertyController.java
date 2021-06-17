package com.meli.tucasita.controller;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import com.meli.tucasita.model.District;
import com.meli.tucasita.model.Property;
import com.meli.tucasita.service.PropertyService;
import com.meli.tucasita.service.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class PropertyController {

  @Autowired
  PropertyService propertyService;

  // US-0000: Testear validaciones de input
  @PostMapping("/newProperty")
  public ResponseEntity<Map<Integer, Property>> addNewProperty (@RequestBody Property property) {
    return new ResponseEntity<>(propertyService.addNewProperty(property), HttpStatus.OK);
  }

  // US-0001: Calcular el total de metros cuadrados de una propiedad
  @GetMapping("/calculateArea/{id}")
  public ResponseEntity<PropertyAreaDTO> getPropertyArea(@PathVariable int id) {
    return new ResponseEntity<>(propertyService.getPropertyArea(id), HttpStatus.OK) ;
  }

  // US-0002: Indicar el valor de una propiedad a partir de sus ambientes y medidas
  @GetMapping("/calculatePrice/{id}")
  public ResponseEntity<PropertyPriceDTO> getPropertyPrice(@PathVariable int id) {
    return new ResponseEntity<>(propertyService.getPropertyPrice(id), HttpStatus.OK) ;
  }

  // US-0003: Determinar cuál es el ambiente más grande
  @GetMapping("/biggestEnvironment/{id}")
  public ResponseEntity<EnvironmentAreaDTO> getBiggestEnvironment(@PathVariable int id) {
    return new ResponseEntity<>(propertyService.getBiggestEnvironment(id), HttpStatus.OK) ;
  }

  // US-0004: Determinar la cantidad de metros cuadrados que tiene cada ambiente de una propiedad
  @GetMapping("/environments/{id}")
  public ResponseEntity<List<EnvironmentAreaDTO>> getPropertyEnvironments(@PathVariable int id) {
    return new ResponseEntity<>(propertyService.getPropertyEnvironments(id), HttpStatus.OK) ;
  }
}
