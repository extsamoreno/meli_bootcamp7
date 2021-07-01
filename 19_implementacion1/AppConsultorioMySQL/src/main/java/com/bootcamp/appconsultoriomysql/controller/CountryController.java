package com.bootcamp.appconsultoriomysql.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/countries")
public class CountryController {

    @GetMapping("/")
    public ResponseEntity<String> getCountries() {
        return new ResponseEntity<>("Holas", HttpStatus.OK);
    }
}

