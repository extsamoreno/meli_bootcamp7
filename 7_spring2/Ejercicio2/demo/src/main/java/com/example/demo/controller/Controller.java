package com.example.demo.controller;

import com.example.demo.services.CalculoFecha;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {

    @GetMapping("/{dia}/{mes}/{ano}")
    public ResponseEntity<Integer>  calcularMetroCuadrado(@PathVariable String dia, @PathVariable String mes, @PathVariable String ano){
        Integer respuesta = CalculoFecha.calcularFechas(dia,mes,ano);

        if (respuesta == -1)
            return new ResponseEntity(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
        else
            return new ResponseEntity(respuesta, HttpStatus.OK);
    }

}
