package com.example.demo.controller;

import com.example.demo.DTO.Alumno;
import com.example.demo.DTO.Diploma;
import com.example.demo.services.GeneracionDiploma;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RestController
public class DiplomaController {

    @PostMapping("/generarDiploma")
    public ResponseEntity<Diploma> calcularMetroCuadrado(@Valid @RequestBody Alumno alumno){

        Diploma respuesta = GeneracionDiploma.generarDiploma(alumno);
        return new ResponseEntity<>(respuesta, HttpStatus.OK);
    }
}
