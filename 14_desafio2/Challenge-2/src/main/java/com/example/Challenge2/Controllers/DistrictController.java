package com.example.Challenge2.Controllers;

import com.example.Challenge2.Services.DTOs.*;
import com.example.Challenge2.Services.IDistrictService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;



@RestController
public class DistrictController {

    @Autowired
    IDistrictService iDistrictService;


    @PostMapping("/districts")
    public ResponseEntity<Boolean>store(@Valid @RequestBody DistrictDTO districtDTO) {
        return new ResponseEntity<>(iDistrictService.storeDistrict(districtDTO),HttpStatus.OK);
    }

}
