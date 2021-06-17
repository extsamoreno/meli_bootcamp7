package com.example.demo.controller;

import com.example.demo.models.*;
import com.example.demo.service.IHouseService;
import com.example.demo.service.dto.HouseBiggestEnvironmentDTO;
import com.example.demo.service.dto.HouseListEnvironmentDTO;
import com.example.demo.service.dto.HouseM2DTO;
import com.example.demo.service.dto.HousePriceDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/house")
public class HouseController {
    @Autowired
    IHouseService iHouseService;
    @GetMapping("/calculatem2")
    public ResponseEntity<HouseM2DTO> getM2(@RequestBody House house){
        HouseM2DTO houseM2DTO = new HouseM2DTO();
        houseM2DTO.setName(house.getProp_name());
        houseM2DTO.setSquareMeter(iHouseService.calculateM2(house));
        ResponseEntity<HouseM2DTO> doubleResponseEntity = new ResponseEntity<>(houseM2DTO, HttpStatus.OK);
        return doubleResponseEntity;
    }
    @GetMapping("/price")
    public ResponseEntity<HousePriceDTO> getPrice(@RequestBody House house){
        HousePriceDTO housePriceDTO = new HousePriceDTO();
        housePriceDTO.setName(house.getProp_name());
        housePriceDTO.setPrice(iHouseService.calculatePrice(house));
        ResponseEntity<HousePriceDTO> doubleResponseEntity = new ResponseEntity<>(housePriceDTO, HttpStatus.OK);
        return doubleResponseEntity;
    }
    @GetMapping("/biggestEnvironment")
    public ResponseEntity<HouseBiggestEnvironmentDTO> getBiggestEnvironment(@RequestBody House house){
        HouseBiggestEnvironmentDTO houseBiggestEnvironmentDTO = new HouseBiggestEnvironmentDTO();
        houseBiggestEnvironmentDTO.setName(house.getProp_name());
        houseBiggestEnvironmentDTO.setBiggestEnvironment(iHouseService.biggestEnvironment(house));
        ResponseEntity<HouseBiggestEnvironmentDTO> doubleResponseEntity = new ResponseEntity<>(houseBiggestEnvironmentDTO, HttpStatus.OK);
        return doubleResponseEntity;
    }
    @GetMapping("/listenvironment")
    public ResponseEntity<HouseListEnvironmentDTO> getListEnvironment (@RequestBody House house){
        HouseListEnvironmentDTO houseListEnvironmentDTO = new HouseListEnvironmentDTO();
        houseListEnvironmentDTO.setName(house.getProp_name());
        houseListEnvironmentDTO.setListEnvironment(iHouseService.environmentM2(house));
        ResponseEntity<HouseListEnvironmentDTO> doubleResponseEntity = new ResponseEntity<>(houseListEnvironmentDTO, HttpStatus.OK);
        return doubleResponseEntity;
    }


}
