package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HelloRestController {

    @GetMapping("/toRoman/{number}")
    public String toRoman(@PathVariable() int number){

        String roman = Conversor.convert(number);
        return "For number #" + number + " the correspondand roman number is: " + roman;

    }

    @GetMapping("/toMorse/{codigo}")
    public String getMorse(@PathVariable("codigo") String morsecode){

        String text = Morse.morseCode(morsecode);
        return "Decodificacion: " + text;
    }

}
