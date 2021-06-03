package com.meli.agecalculator.controller;

import com.meli.agecalculator.service.IAgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AgeController {

    @Autowired
    private IAgeService ageService;

    @GetMapping("/{day}/{month}/{year}")
    public ResponseEntity<Integer> calculateAge(@PathVariable int day, @PathVariable int month, @PathVariable int year) {
        return new ResponseEntity<Integer>(ageService.calculateAge(day, month, year), HttpStatus.OK);
    }
}
