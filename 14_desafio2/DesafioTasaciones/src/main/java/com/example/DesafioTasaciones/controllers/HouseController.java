package com.example.DesafioTasaciones.controllers;

import com.example.DesafioTasaciones.dtos.ResponseDTO;
import com.example.DesafioTasaciones.services.IHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/{house}")
public class HouseController {
    @Autowired
    IHouseService iHouseService;

    //Requirement US-0001
    @GetMapping("/totalSquareMeters/{propertyId}")
    public ResponseEntity<ResponseDTO> totalSquareMeters(@PathVariable Integer propertyId) {
        return new ResponseEntity<>(iHouseService.totalSquareMeters(propertyId), HttpStatus.OK);
    }

    //Requirement US-0002
    @GetMapping("/propertyValue/{propertyId}")
    public ResponseEntity<ResponseDTO> propertyValue(@PathVariable Integer propertyId) {
        return new ResponseEntity<>(iHouseService.propertyValue(propertyId),HttpStatus.OK);
    }

    //Requirement US-0003
    @GetMapping("/largestEnvironment/{propertyId}")
    public ResponseEntity<ResponseDTO> largestEnvironment(@PathVariable Integer propertyId) {
        return new ResponseEntity<>(iHouseService.largestEnvironment(propertyId),HttpStatus.OK);
    }

    //Requirement US-0004
    @GetMapping("/roomsSquareMeters/{propertyId}")
    public ResponseEntity<ResponseDTO> roomsSquareMeters(@PathVariable Integer propertyId) {
        return new ResponseEntity<>(iHouseService.roomsSquareMeters(propertyId),HttpStatus.OK);
    }


}
