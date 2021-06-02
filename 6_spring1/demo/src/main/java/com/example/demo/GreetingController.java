package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/converter")
public class GreetingController {

    @GetMapping("/roman-to-numbers/{number}")
    public String getRoman(@PathVariable("number") int number) {
        return Converter.convert(number);
    }

    @GetMapping("/morse-to-string/{morse}")
    public String getMorse(@PathVariable String morse) {
        return Converter.convertToMorse(morse);
    }
}
