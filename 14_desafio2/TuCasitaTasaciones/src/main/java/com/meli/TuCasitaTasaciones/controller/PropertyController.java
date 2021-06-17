package com.meli.TuCasitaTasaciones.controller;

import com.meli.TuCasitaTasaciones.model.Environment;
import com.meli.TuCasitaTasaciones.model.EnvironmentAreaResponseDTO;
import com.meli.TuCasitaTasaciones.model.HouseDTO;
import com.meli.TuCasitaTasaciones.model.Property;
import com.meli.TuCasitaTasaciones.service.IPropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
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
    public ResponseEntity<Double> calculateArea(@RequestBody List<Environment> environments) {
        return new ResponseEntity<>(service.calculateArea(environments), HttpStatus.OK);
    }

    @PostMapping("Property/calculatePrice")
    public ResponseEntity<Double> calculatePrice(@RequestBody HouseDTO houseDTO) {
        return new ResponseEntity<>(service.calculatePrice(houseDTO), HttpStatus.OK);
    }

    @PostMapping("Property/environmentsBigger")
    public ResponseEntity<EnvironmentAreaResponseDTO> environmentsBigger(@RequestBody List<Environment> environments) {
        return new ResponseEntity<>(service.environmentsBigger(environments), HttpStatus.OK);
    }

    @PostMapping("Property/environmentArea")
    public ResponseEntity<List<EnvironmentAreaResponseDTO>> environmentArea(@RequestBody List<Environment> environments) {
        return new ResponseEntity<>(service.environmentArea(environments), HttpStatus.OK);
    }
}

//@DecimalMin(value = "0.0", message = "La nota no puede ser menor a 0.0")
//@DecimalMax(value = "10.0", message = "La nota no puede ser mayor a 10.0")
