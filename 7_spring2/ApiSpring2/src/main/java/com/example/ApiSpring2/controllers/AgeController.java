package com.example.ApiSpring2.controllers;

import com.example.ApiSpring2.services.AgeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/age")
public class AgeController {
    AgeService service = new AgeService();

    @GetMapping("/{day}/{month}/{year}")
    public Integer getAge(@PathVariable("day") Integer day, @PathVariable("month") Integer month, @PathVariable("year") Integer year){
        return service.obtainAge(day,month,year);
    }
}
