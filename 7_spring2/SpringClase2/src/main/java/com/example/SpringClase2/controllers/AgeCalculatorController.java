package com.example.springclase2.controllers;

import com.example.springclase2.services.AgeServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ageCalculator")
public class AgeCalculatorController {

    @GetMapping("/{bornDate}")
    public ResponseEntity<String> getAge(@PathVariable String bornDate)
    {
        if (AgeServices.calculateAge(bornDate) != "-1") {
            return new ResponseEntity<>(AgeServices.calculateAge(bornDate), HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>
                    ("Fecha de entrada incorrecta.\nIntente de nuevo...", HttpStatus.EXPECTATION_FAILED);
        }
    }

}
