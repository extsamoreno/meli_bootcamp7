package com.example.demo.controller;

import com.example.demo.dto.PlatoRequestDTO;
import com.example.demo.dto.PlatoResponseDTO;
import com.example.demo.services.PlatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/calculadora")
public class CalculadoraController {
    @Autowired
    PlatoService platoService;


    @PostMapping("/caloriasTotales")
    public ResponseEntity<PlatoResponseDTO> caloriasTotales (@RequestBody PlatoRequestDTO plato){
        return new ResponseEntity<> (platoService.caloriasTotalesPlato(plato), HttpStatus.OK);
    }

}
