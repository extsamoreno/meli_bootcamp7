package com.example.exercises.Controllers;

import com.example.exercises.Service.AgeCalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Period;

@RestController("/ex2")
public class AgeCalculatorController {

    @Autowired
    private AgeCalculatorService ageCalculatorService;

    @GetMapping("/{day}/{month}/{year}")
    public ResponseEntity<?> calculateAge(@PathVariable int day, @PathVariable int month, @PathVariable int year) {
        int years = ageCalculatorService.calculateAge(day,month,year);
        return new ResponseEntity<>(years, HttpStatus.OK);
    }
}
