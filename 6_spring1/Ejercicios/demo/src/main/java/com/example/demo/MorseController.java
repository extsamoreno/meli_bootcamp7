package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/num")
public class MorseController {

    @GetMapping("/CodigoMorse/{codigo}")
    public String getCodigoMorse(@PathVariable String codigo) { return CodigoMorse.convertCodigoMorse(codigo); }
}
