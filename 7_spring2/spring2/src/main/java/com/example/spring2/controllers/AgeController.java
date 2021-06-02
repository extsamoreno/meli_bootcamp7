package com.example.spring2.controllers;

import org.joda.time.Years;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/age")
public class AgeController {

    @GetMapping("/{day}/{month}/{year}")
    public ResponseEntity<String> getAge(@PathVariable Integer day,
                                         @PathVariable Integer month,
                                         @PathVariable Integer year) {
        org.joda.time.LocalDate now = new org.joda.time.LocalDate();
        org.joda.time.LocalDate birthday = new org.joda.time.LocalDate(year, month, day);
        int result = Years.yearsBetween(birthday, now).getYears();
        return new ResponseEntity(String.valueOf(result), HttpStatus.OK);
    }
}
