package com.meli.squaremeters.controller;

import com.meli.squaremeters.domain.House;
import com.meli.squaremeters.domain.HouseDTO;
import com.meli.squaremeters.services.HouseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SquareMetersController {

    @PostMapping("/getHouseData")
    public ResponseEntity<HouseDTO> getHouseData(@RequestBody House house) {
        return new ResponseEntity<HouseDTO>
                (HouseService.getHouseData(house),
                        HttpStatus.OK);
    }
}
