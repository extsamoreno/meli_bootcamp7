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

    @PostMapping("/calculate")
    public ResponseEntity <HouseDTO> getSquareMettersByHouse(@RequestBody House house){

        return new ResponseEntity<HouseDTO>(houseService.calculate(house), HttpStatus.OK);
    }
}
