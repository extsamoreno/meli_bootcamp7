package com.example.ChallengeTwo.controller;

import com.example.ChallengeTwo.dto.HouseTotalAreaDTO;
import com.example.ChallengeTwo.service.IHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/house")
public class HouseController {

    @Autowired
    IHouseService iHouseService;
    @GetMapping ("/totalArea/{houseName}")
    public ResponseEntity<HouseTotalAreaDTO> getTotalAreaHouse(@PathVariable String houseName){
        return new ResponseEntity<>(iHouseService.getTotalAreaHouse(houseName), HttpStatus.OK);

    }


}
