package com.desafiotesting.desafiotesting.controllers;
import com.desafiotesting.desafiotesting.services.dtos.EnviromentDTO;
import com.desafiotesting.desafiotesting.services.dtos.EnviromentWithSquareMetersDTO;
import com.desafiotesting.desafiotesting.services.dtos.PropertyDTO;
import com.desafiotesting.desafiotesting.services.IPropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/property")
public class PropertyController {

    @Autowired
    IPropertyService propertyService;

    @PostMapping("/registerproperty")
    public ResponseEntity<?> registerProperty(@RequestBody @Valid PropertyDTO propertyDTO){
        this.propertyService.create(propertyDTO);
        return ResponseEntity.ok(null);
    }

    @PostMapping("/totalsquaremeters/{id}")
    public double totalSquareMeters(@PathVariable int id) {
        return propertyService.totalSquareMeters(id);
    }

    @PostMapping("/priceproperty/{id}")
    public double getPriceProperty(@PathVariable int id){
        return propertyService.getPriceProperty(id);
    }

    @PostMapping("/biggerenviroment/{id}")
    public EnviromentDTO getBiggerEnviroment(@PathVariable int id){
        return propertyService.getBiggerEnviroment(id);
    }

    @PostMapping("/enviromentsinfo/{id}")
    public List<EnviromentWithSquareMetersDTO> getEnviromentsInfo(@PathVariable int id){
        return propertyService.getEnviromentsInfo(id);
    }


}
