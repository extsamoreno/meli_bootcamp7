package com.example.demo.controller;

import com.example.demo.services.ConvertRomanServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/convert")
public class RomansController {


    @Autowired
    ConvertRomanServices romanServices;


    @GetMapping("/int-to-roman/{numero}")
    public String convertToRoman(@PathVariable int numero){
        return romanServices.integerToRoman(numero);
    }

}
