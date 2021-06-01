package com.example.API_Spring1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/convert")
public class RomanController {

    @GetMapping("/{number}")
    public static String convertirANumerosRomanos(@PathVariable int number)
    {
        return number + " en romano es " + (RomanNumber.convertirANumerosRomanos(number));
    }
}