package com.example.demo.ex2;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/calculate")
public class CalculatorController {

    CalculatorService calculator = new CalculatorService();

    @GetMapping("/age/{day}/{month}/{year}")
    public ResponseEntity<Integer> getAge(@PathVariable int day, @PathVariable int month, @PathVariable int year) {

        return new ResponseEntity<>(calculator.calcularEdad(day, month, year), HttpStatus.OK);
    }
}
