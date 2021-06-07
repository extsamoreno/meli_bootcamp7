package com.ejercicio._spring2.ej2.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Period;

@RestController
@RequestMapping
public class AgeController {

    @GetMapping("/{day}/{month}/{year}")
    public ResponseEntity<?> calculateAge(@PathVariable int day,
                                          @PathVariable int month,
                                          @PathVariable int year) {
        int years = serviceCalculateAge(day, month, year);
        return new ResponseEntity<>(years, HttpStatus.OK);
    }

    private Integer serviceCalculateAge(int day, int month, int year) {
        LocalDate date1 = LocalDate.of(year, month, day);
        LocalDate date2 = LocalDate.now();
        Period period = date1.until(date2);
        return period.getYears();
    }



}
