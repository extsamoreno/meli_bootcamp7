package com.example.demo.controller;

import com.example.demo.exception.DistrictNotFoundException;
import com.example.demo.models.District;
import com.example.demo.models.House;
import com.example.demo.service.IHouseService;
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
    IHouseService iHouseService;

    @PostMapping("/new")
    public ResponseEntity<Void> addNewDistrict(@Valid @RequestBody District district) throws DistrictNotFoundException {
        iHouseService.addDistrict(district);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}