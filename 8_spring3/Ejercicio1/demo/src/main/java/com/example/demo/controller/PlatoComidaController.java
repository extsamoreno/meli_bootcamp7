package com.example.demo.controller;

import com.example.demo.DTO.PlatoComidaDTO;
import com.example.demo.services.ICalculoPlatoComida;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlatoComidaController {

    @Autowired
    ICalculoPlatoComida calculoPlatoComida;


    @PostMapping("/calcularPlatoComida")
    public ResponseEntity<PlatoComidaDTO> calcularPlatoComida(@RequestBody PlatoComidaDTO platoComidaDTO){

        return new ResponseEntity<> (calculoPlatoComida.calcularPlatoComida(platoComidaDTO), HttpStatus.OK);
    }
}
