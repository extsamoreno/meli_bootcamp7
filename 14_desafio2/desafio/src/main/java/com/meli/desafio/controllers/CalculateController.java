package com.meli.desafio.controllers;

import com.meli.desafio.models.House;
import com.meli.desafio.services.ICalculateService;
import com.meli.desafio.utils.URLBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/calculate")
public class CalculateController {

    @Autowired
    private ICalculateService calculateService;

    @PostMapping
    public ResponseEntity<String> addHouse(@Valid @RequestBody House house){
        return new ResponseEntity<>(URLBuilder.buildURL("", calculateService.save(house), ""), HttpStatus.OK);
    }
}
