package com.desafio2.Controller;

import com.desafio2.Model.Environment;
import com.desafio2.Model.Property;
import com.desafio2.Service.IPropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/property/")
public class PropertyController {

    @Autowired
    IPropertyService iPropertyService;

    @PostMapping("/create")
    public ResponseEntity<?> createProperty(@RequestBody @Valid Property property) {
        this.iPropertyService.create(property);
        return ResponseEntity.ok(null);
    }

    //US-0001: Calcular el total de metros cuadrados de una propiedad
    @GetMapping("/totalSqaureMeters/{property_name}")
    public ResponseEntity<Double> getTotalSqaureMeters(@PathVariable String property_name) {
        return new ResponseEntity<>(iPropertyService.getTotalSquareMeters(property_name), HttpStatus.OK);
    }

    //US-0002: Indicar el valor de una propiedad a partir de sus ambientes y medidas.
    //Tener en cuenta que los precios por metro cuadrado están determinados según el
    //barrio.
    @GetMapping("/price/{property_name}")
    public ResponseEntity<Double> getPropertyPrice(@PathVariable String property_name) {
        return new ResponseEntity<>(iPropertyService.getPropertyPrice(property_name), HttpStatus.OK);
    }

    //US-0003: Determinar cuál es el ambiente más grande.
    @GetMapping("/biggestEnvironment/{property_name}")
    public ResponseEntity<Environment> getBiggestEnvironment(@PathVariable String property_name) {
        return new ResponseEntity<>(iPropertyService.getBiggestEnvironment(property_name), HttpStatus.OK);
    }

    //US-0004: Determinar la cantidad de metros cuadrados que tiene cada ambiente de una propiedad.
    @GetMapping("/listEnvironments/{property_name}")
    public ResponseEntity<List<Environment>> getEnvironmentsSquareMeters(@PathVariable String property_name) {
        return new ResponseEntity(iPropertyService.getEnvironmentListWithSquareMeters(property_name), HttpStatus.OK);
    }
}