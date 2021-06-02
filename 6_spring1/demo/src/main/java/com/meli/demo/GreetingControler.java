package com.meli.demo;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/greetings")
public class GreetingControler {

//    @PostMapping
//    @PutMapping
//    @GetMapping("/hello/{name}")
//    public String getHello(@PathVariable() String name){
//  public String getHello(@PathVariable(name) String ahoraPuedoUsarOtroName){
//        return "Hello " + name;
//    }

    @GetMapping("/toroman/{number}")
    public String getHello(@PathVariable() int number){

        String roman = ToRoman.convert(number);
        return "For number #" + number + " the correspondand roman number is: " + roman;
    }

    @GetMapping("/morsecode/{codigo}")
    public String getMorse(@PathVariable("codigo") String morsecode){

        String text = Morse.toText(morsecode);
        return "Decodificacion: " + text;
    }

}


