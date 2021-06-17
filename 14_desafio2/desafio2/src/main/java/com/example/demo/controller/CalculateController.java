package com.example.demo.controller;

import com.example.demo.exception.DistrictNotFoundException;
import com.example.demo.exception.HouseNotFoundException;
import com.example.demo.models.*;
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
    public ResponseEntity<HouseDTO> calculateAllRequirements(@PathVariable String name) throws HouseNotFoundException, DistrictNotFoundException {
        HouseDTO houseDTO = new HouseDTO(name, iHouseService.calculateM2(name), iHouseService.calculatePrice(name), iHouseService.biggestEnvironment(name),
                iHouseService.environmentM2(name));
        ResponseEntity<HouseDTO> responseEntity = new ResponseEntity<>(houseDTO, HttpStatus.OK);
        return responseEntity;
    }
    //US-0001
    @GetMapping("/calculatem2/{name}")
    public ResponseEntity<HouseM2DTO> getM2(@PathVariable String name) throws HouseNotFoundException, DistrictNotFoundException {
        HouseM2DTO houseM2DTO = new HouseM2DTO();
        houseM2DTO.setName(name);
        houseM2DTO.setSquareMeter(iHouseService.calculateM2(name));
        ResponseEntity<HouseM2DTO> doubleResponseEntity = new ResponseEntity<>(houseM2DTO, HttpStatus.OK);
        return doubleResponseEntity;
    }
    //US-0002
    @GetMapping("/price/{name}")
    public ResponseEntity<HousePriceDTO> getPrice(@PathVariable String name) throws HouseNotFoundException, DistrictNotFoundException {
        HousePriceDTO housePriceDTO = new HousePriceDTO();
        housePriceDTO.setName(name);
        housePriceDTO.setPrice(iHouseService.calculatePrice(name));
        ResponseEntity<HousePriceDTO> doubleResponseEntity = new ResponseEntity<>(housePriceDTO, HttpStatus.OK);
        return doubleResponseEntity;
    }
    //US-0003
    @GetMapping("/biggestEnvironment/{name}")
    public ResponseEntity<HouseBiggestEnvironmentDTO> getBiggestEnvironment(@PathVariable String name) throws HouseNotFoundException, DistrictNotFoundException {
        HouseBiggestEnvironmentDTO houseBiggestEnvironmentDTO = new HouseBiggestEnvironmentDTO();
        houseBiggestEnvironmentDTO.setName(name);
        houseBiggestEnvironmentDTO.setBiggestEnvironment(iHouseService.biggestEnvironment(name));
        ResponseEntity<HouseBiggestEnvironmentDTO> doubleResponseEntity = new ResponseEntity<>(houseBiggestEnvironmentDTO, HttpStatus.OK);
        return doubleResponseEntity;
    }
    //US-0004
    @GetMapping("/listenvironment/{name}")
    public ResponseEntity<HouseListEnvironmentDTO> getListEnvironment (@PathVariable String name) throws HouseNotFoundException {
        HouseListEnvironmentDTO houseListEnvironmentDTO = new HouseListEnvironmentDTO();
        houseListEnvironmentDTO.setName(name);
        houseListEnvironmentDTO.setListEnvironment(iHouseService.environmentM2(name));
        ResponseEntity<HouseListEnvironmentDTO> doubleResponseEntity = new ResponseEntity<>(houseListEnvironmentDTO, HttpStatus.OK);
        return doubleResponseEntity;
    }


}
