package com.nicoll.demo;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/morse")
public class MorsaControlador {

    @GetMapping("{word}")
    public String StringMorse(@PathVariable String word){
        return MorseUtil.morseString(word);
    }
}
