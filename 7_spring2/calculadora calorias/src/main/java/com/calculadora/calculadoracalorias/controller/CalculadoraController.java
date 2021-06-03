package com.calculadora.calculadoracalorias.controller;

import com.calculadora.calculadoracalorias.services.PlatoService;
import com.calculadora.calculadoracalorias.services.dto.PlatoDTO;
import com.calculadora.calculadoracalorias.services.dto.PlatoRequestDTO;
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
    public ResponseEntity<PlatoDTO> caloriasTotales (@RequestBody PlatoRequestDTO plato){
        return new ResponseEntity<> (platoService.caloriasTotalesPlato(plato), HttpStatus.OK);
    }

}
