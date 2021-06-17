package com.meli.TuCasitaTasaciones.controller;

import com.meli.TuCasitaTasaciones.model.EnvironmentDTO;
import com.meli.TuCasitaTasaciones.model.EnvironmentAreaResponseDTO;
import com.meli.TuCasitaTasaciones.model.HouseDTO;
import com.meli.TuCasitaTasaciones.model.PropertyDTO;
import com.meli.TuCasitaTasaciones.service.IPropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class PropertyController {

    @Autowired
    IPropertyService service;

//    @GetMapping("/Property/{idProperty}")
//    public ResponseEntity<Property> getPropertyById(@PathVariable int idProperty) {
//        return new ResponseEntity<>(service.getPropertyById(idProperty), HttpStatus.OK);
//    }
//
//    @GetMapping("/Property/area/{idProperty}")
//    public ResponseEntity<Double> getAreaProperty(@PathVariable int idProperty) {
//        return new ResponseEntity<>(service.getAreaProperty(idProperty), HttpStatus.OK);
//    }
//
//    @GetMapping("/Property/price/{idProperty}")
//    public ResponseEntity<Double> getPriceProperty(@PathVariable int idProperty) {
//        return new ResponseEntity<>(service.getPriceProperty(idProperty), HttpStatus.OK);
//    }
//
//    @GetMapping("/Property/area/bigger")
//    public ResponseEntity<Double> getAreaBigger() {
//        return new ResponseEntity<>(service.getAreaBigger(), HttpStatus.OK);
//    }

    @PostMapping("Property/calculateArea")
    public ResponseEntity<Double> calculateArea( @Valid @RequestBody List<EnvironmentDTO> environmentDTOS) {
        return new ResponseEntity<>(service.calculateArea(environmentDTOS), HttpStatus.OK);
    }

    @PostMapping("Property/calculatePrice")
    public ResponseEntity<Double> calculatePrice( @Valid @RequestBody HouseDTO houseDTO) {
        return new ResponseEntity<>(service.calculatePrice(houseDTO), HttpStatus.OK);
    }

    @PostMapping("Property/environmentsBigger")
    public ResponseEntity<EnvironmentAreaResponseDTO> environmentsBigger( @Valid @RequestBody List<EnvironmentDTO> environmentDTOS) {
        return new ResponseEntity<>(service.environmentsBigger(environmentDTOS), HttpStatus.OK);
    }

    @PostMapping("Property/environmentArea")
    public ResponseEntity<List<EnvironmentAreaResponseDTO>> environmentArea( @Valid @RequestBody List<EnvironmentDTO> environmentDTOS) {
        return new ResponseEntity<>(service.environmentArea(environmentDTOS), HttpStatus.OK);
    }

    @PostMapping("Property/addProperty")
    public ResponseEntity<?> addProperty( @Valid @RequestBody PropertyDTO propertyDTO) {
        this.service.addProperty(propertyDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}