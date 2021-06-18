package com.meli.TuCasitaTasaciones.controller;

import com.meli.TuCasitaTasaciones.model.*;
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

    @PostMapping("Property/calculateArea")
    public ResponseEntity<Double> calculateArea(@Valid @RequestBody EnvironmentListDTO environmentDTOS) {
        return new ResponseEntity<>(service.calculateArea(environmentDTOS), HttpStatus.OK);
    }

    @PostMapping("Property/calculatePrice")
    public ResponseEntity<Double> calculatePrice(@Valid @RequestBody HouseDTO houseDTO) {
        return new ResponseEntity<>(service.calculatePrice(houseDTO), HttpStatus.OK);
    }

    @PostMapping("Property/environmentsBiggest")
    public ResponseEntity<EnvironmentAreaResponseDTO> environmentsBiggest(@Valid @RequestBody EnvironmentListDTO environmentDTOS) {
        return new ResponseEntity<>(service.environmentsBiggest(environmentDTOS), HttpStatus.OK);
    }

    @PostMapping("Property/environmentArea")
    public ResponseEntity<List<EnvironmentAreaResponseDTO>> environmentArea(@Valid @RequestBody EnvironmentListDTO environmentDTOS) {
        return new ResponseEntity<>(service.environmentArea(environmentDTOS), HttpStatus.OK);
    }

    @PostMapping("Property/addProperty")
    public ResponseEntity<?> addProperty(@Valid @RequestBody PropertyDTO propertyDTO) {
        service.addProperty(propertyDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}

//        Agregar una excepción al crear una propiedad (si ya existe).
//        Borrar código comentado.
//        Se podría agregar un DistrictDTO y no utilizar el DistrictDTO para validar datos y recibir un nuevo district.
//        Se podría dividir el repo de district y property.
//        Validar que el district existe.
//        No todos los endpoints validan los datos (length width, etc)