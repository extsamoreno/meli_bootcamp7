package com.meli.squaremeters.controller;

import com.meli.squaremeters.domain.House;
import com.meli.squaremeters.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SquareMetersController {

    @Autowired
    HouseService houseService;

    @PostMapping("/get-house-data")
    public ResponseEntity<?> getHouseData(@RequestBody House house) {
        return new ResponseEntity<>(houseService.getHouseDTO(house), HttpStatus.OK);
    }
}
