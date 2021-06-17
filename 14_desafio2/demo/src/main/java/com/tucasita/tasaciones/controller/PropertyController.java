package com.tucasita.tasaciones.controller;

import com.tucasita.tasaciones.DTO.PropertyDTO;
import com.tucasita.tasaciones.services.IPropertyServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class PropertyController {

    @Autowired
    IPropertyServices propertyServices;


    @GetMapping("/getSquareMeter/{id}")
    public ResponseEntity<PropertyDTO> calculateSquareMeter(@PathVariable int id){
        return new ResponseEntity<>(propertyServices.calculateSquareMeter(id), HttpStatus.OK);
    }

    @GetMapping("/analyzeScores/")
    public void analyzeScores() {
        System.out.println("Prubesa");
    }

}
