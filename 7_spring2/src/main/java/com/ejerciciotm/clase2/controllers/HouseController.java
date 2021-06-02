package com.ejerciciotm.clase2.controllers;

import com.ejerciciotm.clase2.models.House;
import com.ejerciciotm.clase2.models.HouseDTO;
import com.ejerciciotm.clase2.services.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/houses")
public class HouseController {

    @Autowired
    private HouseService houseService;

    @PostMapping("/square-metters")
    public ResponseEntity <HouseDTO> getSquareMettersByHouse(@RequestBody House house){

        return new ResponseEntity<HouseDTO>(houseService.calculateSquareMettersByHouse(house), HttpStatus.OK);
    }

    @PostMapping("/amount")
    public ResponseEntity <HouseDTO> getAmountByHouse(@RequestBody House house){

        return new ResponseEntity<HouseDTO>(houseService.calculateAmountByHouse(house), HttpStatus.OK);
    }

    @PostMapping("/biggest-room")
    public ResponseEntity <HouseDTO> getBiggestRoomByHouse(@RequestBody House house){

        return new ResponseEntity<HouseDTO>(houseService.calculateBiggestRoom(house), HttpStatus.OK);
    }

    @PostMapping("/square-metters-room")
    public ResponseEntity <HouseDTO> getSquareMettersRoomByHouse(@RequestBody House house){

        return new ResponseEntity<HouseDTO>(houseService.calculateSquareMettersByRoom(house), HttpStatus.OK);
    }
}
