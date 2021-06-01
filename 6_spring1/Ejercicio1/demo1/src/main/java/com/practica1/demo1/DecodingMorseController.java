package com.practica1.demo1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/translate")
public class DecodingMorseController {

    @GetMapping("/decodingmorse/{code}")
    public String decodingMorse(@PathVariable String code){
        MorseToLatin g = new MorseToLatin();
        String message = g.translateMessage(code);
        return message;
    }
}
