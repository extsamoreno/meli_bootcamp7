package com.example.DesafioTasaciones.controllers;

import com.example.DesafioTasaciones.dtos.ResponseDTO;
import com.example.DesafioTasaciones.services.IPropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/{house}")
public class PropertyController {
    @Autowired
    IPropertyService iPropertyService;

    //US0001
    @GetMapping("/totalSquareMeters/{propertyId}")
    public ResponseEntity<ResponseDTO> totalSquareMeters(@PathVariable Integer propertyId) {
        return new ResponseEntity<>(iPropertyService.totalSquareMeters(propertyId), HttpStatus.OK);
    }

    //US0002
    @GetMapping("/propertyValue/{propertyId}")
    public ResponseEntity<ResponseDTO> propertyValue(@PathVariable Integer propertyId) {
        return new ResponseEntity<>(iPropertyService.propertyValue(propertyId),HttpStatus.OK);
    }

    //US0003
    @GetMapping("/largestEnvironment/{propertyId}")
    public ResponseEntity<ResponseDTO> largestEnvironment(@PathVariable Integer propertyId) {
        return new ResponseEntity<>(iPropertyService.largestEnvironment(propertyId),HttpStatus.OK);
    }

    //US0004
    @GetMapping("/roomsSquareMeters/{propertyId}")
    public ResponseEntity<ResponseDTO> roomsSquareMeters(@PathVariable Integer propertyId) {
        return new ResponseEntity<>(iPropertyService.roomsSquareMeters(propertyId),HttpStatus.OK);
    }


}
