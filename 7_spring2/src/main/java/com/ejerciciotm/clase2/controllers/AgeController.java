package com.ejerciciotm.clase2.controllers;

import com.ejerciciotm.clase2.models.Age;
import com.ejerciciotm.clase2.services.AgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ages")
public class AgeController {

    @Autowired
    private AgeService ageService;

    @GetMapping("/{day}/{month}/{year}")
    public ResponseEntity<Age> getAge(@PathVariable Integer day, @PathVariable Integer month, @PathVariable Integer year){
        return new ResponseEntity<Age>(ageService.calculateAge(day, month, year), HttpStatus.OK);
    }
}
