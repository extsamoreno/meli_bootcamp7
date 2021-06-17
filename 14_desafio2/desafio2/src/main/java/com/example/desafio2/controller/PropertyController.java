package com.example.desafio2.controller;

import com.example.desafio2.exception.NeighborhoodExceptionNotFound;
import com.example.desafio2.exception.PropertyAlreadyExistsException;
import com.example.desafio2.exception.PropertyExceptionNotFound;
import com.example.desafio2.service.DTO.PropertyDTO;
import com.example.desafio2.service.DTO.PropertyTotalMetresRoomDTO;
import com.example.desafio2.service.DTO.RoomDTO;
import com.example.desafio2.service.IPropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/properties")
public class PropertyController {
    @Autowired
    private IPropertyService propertyService;

    @GetMapping("/{name}/getTotalMetres")
    public ResponseEntity<Double> getTotalMetres(@PathVariable String name) throws PropertyExceptionNotFound {
        return new ResponseEntity<Double>(propertyService.getTotalMetres(name), HttpStatus.OK);
    }
    @GetMapping("/{name}/getValue")
    public ResponseEntity<Double> getValue(@PathVariable String name) throws PropertyExceptionNotFound {
        return new ResponseEntity<Double>(propertyService.getValue(name), HttpStatus.OK);
    }
    @GetMapping("/{name}/getBiggestRoom")
    public ResponseEntity<RoomDTO> getBiggestRoom(@PathVariable String name) throws PropertyExceptionNotFound {
        return new ResponseEntity<RoomDTO>(propertyService.getBiggestRoom(name), HttpStatus.OK);
    }
    @GetMapping("/{name}/getTotalEachRoom")
    public ResponseEntity<List<PropertyTotalMetresRoomDTO>> getTotalEachRoom(@PathVariable String name) throws PropertyExceptionNotFound {
        return new ResponseEntity<List<PropertyTotalMetresRoomDTO>>(propertyService.getTotalEachRoom(name), HttpStatus.OK);
    }
    @PostMapping("/createProperty")
    public ResponseEntity<?> createProperty(@RequestBody PropertyDTO property) throws PropertyExceptionNotFound, NeighborhoodExceptionNotFound, PropertyAlreadyExistsException {
        propertyService.createProperty(property);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}