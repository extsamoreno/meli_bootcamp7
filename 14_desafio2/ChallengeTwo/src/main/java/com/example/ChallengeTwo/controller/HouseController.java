package com.example.ChallengeTwo.controller;

import com.example.ChallengeTwo.dto.BiggerEnvironmentDTO;
import com.example.ChallengeTwo.dto.EnvironmentAreaDTO;
import com.example.ChallengeTwo.dto.HouseTotalAreaDTO;
import com.example.ChallengeTwo.dto.HouseTotalValueDTO;
import com.example.ChallengeTwo.service.IHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/house")
public class HouseController {

    @Autowired
    IHouseService iHouseService;


    @GetMapping ("/totalArea/{houseName}")
    public ResponseEntity<HouseTotalAreaDTO> getTotalAreaHouse(@PathVariable String houseName){
        return new ResponseEntity<>(iHouseService.getTotalAreaHouse(houseName), HttpStatus.OK);

    }
    @GetMapping("/value/{houseName}")
    public ResponseEntity<HouseTotalValueDTO> getTotalValueHouse(@PathVariable String houseName){
        return new ResponseEntity<>( iHouseService.getTotalValueHouse(houseName), HttpStatus.OK);
    }
    @GetMapping("/biggerEnvironment/{houseName}")
    public ResponseEntity<BiggerEnvironmentDTO> getBiggerEnvironment(@PathVariable String houseName){
        return new ResponseEntity<>( iHouseService.getBiggerEnviroment(houseName), HttpStatus.OK);
    }
    @GetMapping("/environmentsAreaList/{houseName}")
    public ResponseEntity<List<EnvironmentAreaDTO>> getAllEnviromentsArea(@PathVariable String houseName){
        return new ResponseEntity<>( iHouseService.getAllEnviromentsArea(houseName), HttpStatus.OK);
    }


}
