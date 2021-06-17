package com.example.demo.controllers;

import com.example.demo.exceptions.DistrictDontFoundException;
import com.example.demo.services.DistrictService;
import com.example.demo.services.dtos.DistrictDTO;
import com.example.demo.services.dtos.DistrictRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/districts")
public class DistrictController {

    @Autowired
    DistrictService districtService;

    @PostMapping("/add")
    ResponseEntity<DistrictRequestDTO> createDistrict(@Valid @RequestBody DistrictRequestDTO districtRequestDTO){
            return new ResponseEntity<>(districtService.createDistrict(districtRequestDTO), HttpStatus.CREATED);
    }

    @GetMapping("/district/{distId}")
    ResponseEntity<DistrictDTO> findDistrictById(@PathVariable int distId) throws DistrictDontFoundException {
        return new ResponseEntity<>(districtService.findDistrictById(distId), HttpStatus.OK);
    }

}
