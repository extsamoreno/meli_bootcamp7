package com.ejercitacion.ejercitacion.ages.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Period;

@RestController
@RequestMapping("/calculator")
public class AgeCalculatorController {


    @GetMapping("/age/{day}/{month}/{year}")
    public ResponseEntity<Integer> getAge(@PathVariable Integer day, @PathVariable Integer month, @PathVariable Integer year) {
        String dayString = String.valueOf(day);
        String monthString = String.valueOf(month);
        String yearString = String.valueOf(year);
        if (monthString.length() == 1) {
            monthString = "0".concat(monthString);
        }
        if (dayString.length() == 1) {
            dayString = "0".concat(dayString);
        }
        int age = Period.between(LocalDate.parse(yearString + "-" + monthString + "-" + dayString), LocalDate.now()).getYears();
        return ResponseEntity.ok(age);
    }
}
