package com.example.desafio2.controllers;

import com.example.desafio2.dtos.DistrictDTO;
import com.example.desafio2.services.IDistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/districts")
public class DistrictController {
    @Autowired
    IDistrictService iDistrictService;

    @PostMapping("/add")
    public ResponseEntity<String> addDistrict(@RequestBody DistrictDTO district){
        int id = iDistrictService.add(district);
        return new ResponseEntity<>("District submitted succesfully! ID assigned: " + id, HttpStatus.CREATED);
    }
}
