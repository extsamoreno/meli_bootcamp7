package com.example.desafio2.controllers;

import com.example.desafio2.dtos.*;
import com.example.desafio2.exceptions.DistrictIdNotValidException;
import com.example.desafio2.exceptions.PropertyIdNotValidException;
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
    public ResponseEntity<String> postProperty(@Valid @RequestBody PropertyDTO prop) throws DistrictIdNotValidException {
        int id = iPropertyService.add(prop);
        return new ResponseEntity<>("Property submitted successfully! ID assigned: " + id, HttpStatus.CREATED);
    }

    @GetMapping("/{propertyId}/area")
    public ResponseEntity<AreaDTO> getArea(@PathVariable int propertyId) throws PropertyIdNotValidException {
        return new ResponseEntity<>(new AreaDTO(propertyId, iPropertyService.getArea(propertyId)), HttpStatus.OK);
    }

    @GetMapping("/{propertyId}/price")
    public ResponseEntity<PriceDTO> getPrice(@PathVariable int propertyId) throws PropertyIdNotValidException {
        return new ResponseEntity<>(new PriceDTO(propertyId, iPropertyService.getPrice(propertyId)), HttpStatus.OK);
    }

    @GetMapping("/{propertyId}/rooms/biggest")
    public ResponseEntity<RoomDTO> getBiggestRoom(@PathVariable int propertyId) throws PropertyIdNotValidException {
        return new ResponseEntity<>(iPropertyService.getBiggestRoom(propertyId), HttpStatus.OK);
    }

    @GetMapping("/{propertyId}/rooms/area")
    public ResponseEntity<List<RoomAreaDTO>> getAreaPerRoom(@PathVariable int propertyId) throws PropertyIdNotValidException {
        return new ResponseEntity<>(iPropertyService.getRoomsAreas(propertyId), HttpStatus.OK);
    }
}




