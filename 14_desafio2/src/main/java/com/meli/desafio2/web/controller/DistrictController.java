package com.meli.desafio2.web.controller;

import com.meli.desafio2.web.dto.DistrictDTO;
import com.meli.desafio2.web.service.IDistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/district/")
public class DistrictController {
    @Autowired
    IDistrictService iDistrictService;

    @GetMapping("/getDistrict/{name}")
    public ResponseEntity<DistrictDTO> getDistrict(@PathVariable("name") String name){
        return new ResponseEntity<>(iDistrictService.getDistrictByName(name), HttpStatus.OK);
    }

}
