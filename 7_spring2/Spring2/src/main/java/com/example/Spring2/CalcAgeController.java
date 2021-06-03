package com.example.Spring2;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/calcAge")
public class CalcAgeController {

    @GetMapping("/{day}/{month}/{year}")
    public ResponseEntity<Integer> calculateAge(@PathVariable Integer day, @PathVariable Integer month, @PathVariable Integer year) {
        return (new ResponseEntity<>(Calculator.calcAge(day, month, year), HttpStatus.OK));
    }
}
