package com.meli.API_age.controller;

import com.meli.API_age.service.AgeCalculate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
@RequestMapping("/")
public class Age {
    @GetMapping("/")
    public ResponseEntity<String> getMain() {
        String message = "Welcome to the Ages API";
        return new ResponseEntity<>(message, HttpStatus.ACCEPTED);
    }

    @GetMapping("/{day}/{month}/{year}")
    public ResponseEntity<Integer> getAge(@PathVariable int day, @PathVariable int month, @PathVariable int year ) {
        try {
            return new ResponseEntity<>(AgeCalculate.calculate(day,month,year), HttpStatus.ACCEPTED);
        } catch (ParseException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }



    }
}
