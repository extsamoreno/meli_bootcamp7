package com.springbootday2.springbootday2.controllers;

import com.springbootday2.springbootday2.services.CalculatorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {
    private CalculatorService calculatorService;

    public CalculatorController() {
        this.calculatorService = new CalculatorService();
    }

    @GetMapping("/{day}/{month}/{year}")
    public int getMeterPow2ByHouse(@PathVariable int day, @PathVariable int month,@PathVariable int year) {
        return this.calculatorService.getYears(day, month, year);
    }
}
