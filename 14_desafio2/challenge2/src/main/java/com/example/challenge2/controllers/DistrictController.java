package com.example.challenge2.controllers;

import com.example.challenge2.models.District;
import com.example.challenge2.serivces.IDistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/district")
public class DistrictController {

    @Autowired
    IDistrictService districtService;


    @PostMapping("/record")
    public ResponseEntity<District> registerDistrict(@RequestBody @Valid District district) {

        return new ResponseEntity<>(this.districtService.create(district), HttpStatus.CREATED);
    }



}
