package com.calculator.calculator.controllers;

import com.calculator.calculator.dtos.PlateDTO;
import com.calculator.calculator.services.ICalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/plates")
public class CalculatorController {
    @Autowired
    ICalculatorService calculatorService;

    @PostMapping
    public ResponseEntity<PlateDTO> calculateCalories(@RequestBody PlateDTO plateDTO) {
        var result = calculatorService.calculateCaloriesByPlate(plateDTO);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("/all")
    public ResponseEntity<List<PlateDTO>> getPlateProcessed(@RequestBody List<PlateDTO> plateDTO) {
        var result = calculatorService.calculateCaloriesByPlate(plateDTO);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
