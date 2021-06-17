package com.example.challenge2.controllers;

import com.example.challenge2.dtos.PriceDTO;
import com.example.challenge2.dtos.PropertyDTO;
import com.example.challenge2.dtos.TotalAreaDTO;
import com.example.challenge2.service.IPropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/property")
public class PropertyController {

    @Autowired
    IPropertyService iPropertyService;

    @PostMapping("/totalAreaDTO")
    public ResponseEntity<TotalAreaDTO> totalAreaDTO(@Valid @RequestBody PropertyDTO house) throws Exception {
        return new ResponseEntity<>(service.totalArea(house), HttpStatus.OK);
    }

    @PostMapping("/price")
    public ResponseEntity<PriceDTO> price(@Valid @RequestBody PropertyDTO house) throws Exception {
        return new ResponseEntity<>(service.price(house), HttpStatus.OK);
    }
}
