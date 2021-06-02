package com.example.ejercicio1.controller;


import com.example.ejercicio1.domain.House;
import com.example.ejercicio1.dto.HouseDTO;
import com.example.ejercicio1.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SquareMetersController {

    @Autowired
    HouseService houseService;

    @PostMapping("/getHouseData")
    public ResponseEntity<?> getHouseData(@RequestBody House house) {
        HouseDTO response = houseService.getHouseDTO(house);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/habitacion")
    public House getCasa(){
        return houseService.getCasaConHabitacionMasGrande();
    }

}
