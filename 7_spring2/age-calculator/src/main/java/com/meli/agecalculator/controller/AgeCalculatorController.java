package com.meli.agecalculator.controller;

import com.meli.agecalculator.service.AgeCalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Period;
import java.util.HashMap;
import java.util.Map;

@RestController
public class AgeCalculatorController {

    @Autowired
    AgeCalculatorService ageCalculatorService;

    @GetMapping("/{day}/{month}/{year}")
    public ResponseEntity<?> calculateAge(@PathVariable int day, @PathVariable int month, @PathVariable int year) {
        Map<String, Object> response = new HashMap<>(){{
           put("years",ageCalculatorService.calculateAge(day, month, year));
        }};

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
