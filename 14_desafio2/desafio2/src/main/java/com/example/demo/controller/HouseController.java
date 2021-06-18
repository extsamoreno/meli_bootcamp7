package com.example.demo.controller;

import com.example.demo.exception.DistrictNotFoundException;
import com.example.demo.models.House;
import com.example.demo.service.IHouseService;
import com.example.demo.service.dto.HouseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/house")
public class HouseController {
    @Autowired
    IHouseService iHouseService;
    @PostMapping("/new")
    public ResponseEntity<Void> addNewHouse (@Valid @RequestBody HouseDTO houseDTO) throws DistrictNotFoundException {
        iHouseService.addHouse(houseDTO);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}
