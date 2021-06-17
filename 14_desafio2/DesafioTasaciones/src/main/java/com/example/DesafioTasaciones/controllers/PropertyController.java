package com.example.DesafioTasaciones.controllers;

import com.example.DesafioTasaciones.dtos.HouseDTO;
import com.example.DesafioTasaciones.services.IHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/properties")
public class PropertyController {

    @Autowired
    IHouseService iHouseService;

    @PostMapping("/newProperty")
    public ResponseEntity<?> registerNewProperty(@RequestBody @Valid HouseDTO houseDTO) {
        iHouseService.createProperty(houseDTO);
        return ResponseEntity.ok("House Added correctly");
    }

    @GetMapping("/getAllProperties")
    public ResponseEntity<List<HouseDTO>> getAllProperties() {
        return new ResponseEntity<>(iHouseService.getAllProperties(), HttpStatus.OK);
    }
}
