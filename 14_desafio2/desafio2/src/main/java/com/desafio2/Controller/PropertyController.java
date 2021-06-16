package com.desafio2.Controller;

import com.desafio2.Model.Environment;
import com.desafio2.Service.IPropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/property/")
public class PropertyController {

    @Autowired
    IPropertyService iPropertyService;

    //US-0001: Calcular el total de metros cuadrados de una propiedad
    @GetMapping("/totalSqaureMeters/{name}")
    public ResponseEntity<Double> getTotalSqaureMeters(@PathVariable String name) {
        return new ResponseEntity<>(iPropertyService.getTotalSquareMeters(name), HttpStatus.OK);
    }

    //US-0002: Indicar el valor de una propiedad a partir de sus ambientes y medidas.
    //Tener en cuenta que los precios por metro cuadrado están determinados según el
    //barrio.
    @GetMapping("/price/{name}")
    public ResponseEntity<Double> getPropertyPrice(@PathVariable String name) {
        return new ResponseEntity<>(iPropertyService.getPropertyPrice(name), HttpStatus.OK);
    }

    //US-0003: Determinar cuál es el ambiente más grande.
    @GetMapping("/biggestEnvironment/{name}")
    public ResponseEntity<Environment> getBiggestEnvironment(@PathVariable String name) {
        return new ResponseEntity<>(iPropertyService.getBiggestEnvironment(name), HttpStatus.OK);
    }

    //US-0004: Determinar la cantidad de metros cuadrados que tiene cada ambiente de una propiedad.
    @GetMapping("/listEnvironments/{name}")
    public ResponseEntity<List<Environment>> getEnvironmentSquareMeters(@PathVariable String name) {
        return new ResponseEntity(iPropertyService.getEnvironmentListWithSquareMeters(name), HttpStatus.OK);
    }
}
