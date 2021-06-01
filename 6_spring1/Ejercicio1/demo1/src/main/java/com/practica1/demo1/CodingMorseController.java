package com.practica1.demo1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/translate")
public class CodingMorseController {

    @GetMapping("/codingmorse/{message}")
    public String codingMorse(@PathVariable String message){
        LatinToMorse h = new LatinToMorse();
        String code = h.translateMessage(message);
        return code;
    }
}
