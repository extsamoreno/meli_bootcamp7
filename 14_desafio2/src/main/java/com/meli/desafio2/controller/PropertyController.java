package com.meli.desafio2.controller;

import com.meli.desafio2.dto.ResponsePropTotalM2;
import com.meli.desafio2.exception.PropertyIdNotFoundException;
import com.meli.desafio2.service.IPropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/prop")
public class PropertyController {

    @Autowired
    IPropertyService propertyService;

    // Calculate property total square meters (M2)
    @GetMapping("/calcTotalM2/{propId}")
    public ResponseEntity<ResponsePropTotalM2> calcTotalM2(@PathVariable Integer propId) throws PropertyIdNotFoundException {
        return new ResponseEntity<>(propertyService.calcTotalM2(propId), HttpStatus.OK);
    }





}
