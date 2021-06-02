package com.example.exercises.Controllers;

import com.example.exercises.Models.DTO.HouseDTO;
import com.example.exercises.Models.House;
import com.example.exercises.Service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/ex1")
public class HouseController {

    @Autowired
    private HouseService houseService;

    @PostMapping("/house")
    public ResponseEntity<HouseDTO> getHouseData(@RequestBody House house) {
        return new ResponseEntity<>(houseService.getHouseData(house), HttpStatus.OK);
    }
}