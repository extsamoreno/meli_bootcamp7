package com.meli.API_numeros_romanos;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/get_roman")
public class Controller {

    @GetMapping("/")
    public String getMain() {
        return "Bienvenido a la API  de numeros romanos, en la rura `localhost:8080/meli/api/get_roman/{number}`" +
                " podrás recibir el respectivo número romano que coloques en ´{number}´";
    }

    @GetMapping("/{number}")
    public String getRoman (@PathVariable int number) {
        return Roman.convertirANumerosRomanos(number);
    }
}
