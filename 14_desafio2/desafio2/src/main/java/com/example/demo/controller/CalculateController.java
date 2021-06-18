package com.example.demo.controller;

import com.example.demo.exception.DistrictNotFoundException;
import com.example.demo.exception.HouseNotFoundException;
import com.example.demo.service.IHouseService;
import com.example.demo.service.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/house")
public class CalculateController {
    @Autowired
    IHouseService iHouseService;
    @GetMapping("/calculate/{name}")
    public ResponseEntity<ResponseHouseDTO> calculateAllRequirements(@PathVariable String name) throws HouseNotFoundException, DistrictNotFoundException {
        return new ResponseEntity<>(iHouseService.calculateAllRequirements(name), HttpStatus.OK);
    }
    //US-0001
    @GetMapping("/calculatem2/{name}")
    public ResponseEntity<HouseM2DTO> getM2(@PathVariable String name) throws HouseNotFoundException, DistrictNotFoundException {
        return new ResponseEntity<>(iHouseService.getM2(name), HttpStatus.OK);
    }
    //US-0002
    @GetMapping("/price/{name}")
    public ResponseEntity<HousePriceDTO> getPrice(@PathVariable String name) throws HouseNotFoundException, DistrictNotFoundException {
        return new ResponseEntity<>(iHouseService.getPrice(name), HttpStatus.OK);
    }
    //US-0003
    @GetMapping("/biggestEnvironment/{name}")
    public ResponseEntity<HouseBiggestEnvironmentDTO> getBiggestEnvironment(@PathVariable String name) throws HouseNotFoundException, DistrictNotFoundException {
        return new ResponseEntity<HouseBiggestEnvironmentDTO> (iHouseService.getBiggestEnvironment(name),HttpStatus.OK);
    }
    //US-0004
    @GetMapping("/listenvironment/{name}")
    public ResponseEntity<HouseListEnvironmentDTO> getListEnvironment (@PathVariable String name) throws HouseNotFoundException {
        return new ResponseEntity<HouseListEnvironmentDTO>(iHouseService.getListEnvironmentWhitM2(name),HttpStatus.OK);
    }


}
