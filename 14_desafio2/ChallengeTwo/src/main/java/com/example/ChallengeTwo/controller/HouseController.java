package com.example.ChallengeTwo.controller;

import com.example.ChallengeTwo.dto.*;
import com.example.ChallengeTwo.exception.ProgramException;
import com.example.ChallengeTwo.service.IHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import javax.validation.Valid;

@RestController
@RequestMapping("/house")
public class HouseController {

    @Autowired
    IHouseService iHouseService;

    @PostMapping("/createHouse")
    public ResponseEntity<Boolean> createHouse(@Valid @RequestBody HouseDTO house) throws ProgramException {
        return new ResponseEntity<>(iHouseService.createNewHouse(house), HttpStatus.OK);
    }
    @PostMapping("/createDistrict")
    public ResponseEntity<String> createDistrict(@Valid @RequestBody DistrictDTO districtDTO) throws ProgramException {
        System.out.println(districtDTO);
        return new ResponseEntity<>(iHouseService.createNewDistrict(districtDTO), HttpStatus.OK);
    }

    @GetMapping ("/totalArea/{houseName}")
    public ResponseEntity<HouseTotalAreaDTO> getTotalAreaHouse(@PathVariable String houseName) throws ProgramException {
        return new ResponseEntity<>(iHouseService.getTotalAreaHouse(houseName), HttpStatus.OK);

    }
    @GetMapping("/value/{houseName}")
    public ResponseEntity<HouseTotalValueDTO> getTotalValueHouse(@PathVariable String houseName) throws ProgramException {
        return new ResponseEntity<>( iHouseService.getTotalValueHouse(houseName), HttpStatus.OK);
    }
    @GetMapping("/biggerEnvironment/{houseName}")
    public ResponseEntity<BiggestEnvironmentDTO> getBiggestEnvironment(@PathVariable String houseName) throws ProgramException {
        return new ResponseEntity<>( iHouseService.getBiggestEnviroment(houseName), HttpStatus.OK);
    }
    @GetMapping("/environmentsAreaList/{houseName}")
    public ResponseEntity<List<EnvironmentAreaDTO>> getAllEnviromentsArea(@PathVariable String houseName) throws ProgramException {
        return new ResponseEntity<>( iHouseService.getAllEnviromentsArea(houseName), HttpStatus.OK);
    }


}
