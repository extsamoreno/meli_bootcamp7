package com.example.springclase2.controllers;

import com.example.springclase2.dto.*;
import com.example.springclase2.services.HouseServices;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/metrosCuadrados")
public class HouseExerciseController {
    @PostMapping("/save")
    public ResponseEntity<House> save(@RequestBody House house){
        return new ResponseEntity<>(HouseServices.saveHouse(house), HttpStatus.CREATED);
    }

    @GetMapping("/calculateMeters/{houseName}")
    public ResponseEntity<HouseDTO> getSqMeters(@PathVariable String houseName)
    {
//        House h = HouseGenerator.generateHouse();
        return new ResponseEntity<HouseDTO>(HouseServices.getHouseDTO(houseName), HttpStatus.OK);
//        return "Metros cuadarados: " + HouseSqMeterCalculator.calculateSqMeters(h);
    }

}
