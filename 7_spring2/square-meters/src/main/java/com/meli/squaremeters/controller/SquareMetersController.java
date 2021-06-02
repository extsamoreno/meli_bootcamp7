package com.meli.squaremeters.controller;

import com.meli.squaremeters.domain.House;
import com.meli.squaremeters.domain.HouseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SquareMetersController {

    @PostMapping("/getHouseData")
    public ResponseEntity<?> getHouseData(@RequestBody House house) {
        HouseDTO response = new HouseDTO();
        response.setTotalMeters(house.calculateTotalSquareMeters());
        response.setHouseValue(house.getHouseValue(800));
        response.setLargestRoom(house.findLargestRoom());
        response.setRooms(house.getRoomDTO());

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
