package com.example.API_numeros_romanos;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/decimal")

public class Controller {
    @GetMapping("/{number}")
    public String getRoman (@PathVariable int number) {
        return Roman.convertirANumerosRomanos(number);
    }

}
