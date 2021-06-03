package com.spring2.spring2.Controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Period;

@RestController
@RequestMapping("/age")
public class AgeController {
    @GetMapping("/getAge/{day}/{month}/{year}")
    public ResponseEntity<Integer> getSquareMeters(@PathVariable int day,
                                               @PathVariable int month,
                                               @PathVariable int year) {
        int age;

        LocalDate birthDate = LocalDate.of(year, month, day);

        age = Period.between(birthDate, LocalDate.now()).getYears();

        return new ResponseEntity<>(age, HttpStatus.OK);
    }
}
