package com.example.desafio2.controllers;

import com.example.desafio2.dtos.PropertyDTO;
import com.example.desafio2.dtos.RoomDTO;
import com.example.desafio2.dtos.RoomAreaDTO;
import com.example.desafio2.services.IPropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/properties")
@RestController
public class PropertyController {
    @Autowired
    IPropertyService iPropertyService;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.OK)
    public void postProperty(@Valid @RequestBody PropertyDTO prop){
        iPropertyService.add(prop);
    }

    @GetMapping("/{propertyId}/area")
    public double getArea(@PathVariable int propertyId){
        return iPropertyService.getArea(propertyId);
    }

    @GetMapping("/{propertyId}/price")
    public double getPrice(@PathVariable int propertyId){
        return iPropertyService.getPrice(propertyId);
    }

    @GetMapping("/{propertyId}/rooms/biggest")
    public ResponseEntity<RoomDTO> getBiggestRoom(@PathVariable int propertyId){
        return new ResponseEntity<>(iPropertyService.getBiggestRoom(propertyId),HttpStatus.OK);
    }

    @GetMapping("/{propertyId}/rooms/area")
    public ResponseEntity<List<RoomAreaDTO>> getSquareMetersPerRoom(@PathVariable int propertyId){
        return new ResponseEntity<>(iPropertyService.getRoomsAreas(propertyId),HttpStatus.OK);
    }
}




