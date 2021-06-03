package com.calculadora.calculadoracalorias.controller;

import com.calculadora.calculadoracalorias.dto.IngredienteResponseDTO;
import com.calculadora.calculadoracalorias.dto.IngredientesRequestDTO;
import com.calculadora.calculadoracalorias.services.PlatoService;
import com.calculadora.calculadoracalorias.dto.PlatoResponseDTO;
import com.calculadora.calculadoracalorias.dto.PlatoRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/calculadora")



public class CalculadoraController {
    @Autowired
    PlatoService platoService;


    @PostMapping("/caloriasTotales")
    public ResponseEntity<PlatoResponseDTO> caloriasTotales (@RequestBody PlatoRequestDTO plato){
        return new ResponseEntity<> (platoService.caloriasTotalesPlato(plato), HttpStatus.OK);
    }

    @PostMapping("/caloriasCadaIngrediente")
    public ResponseEntity<ArrayList<IngredienteResponseDTO>> caloriasCadaIngrediente (@RequestBody PlatoRequestDTO plato){
        return new ResponseEntity<> (platoService.caloriasCadaIngrediente(plato), HttpStatus.OK);
    }

    @PostMapping("/ingredienteConMasCalorias")
    public ResponseEntity<IngredienteResponseDTO> ingredienteConMasCalorias (@RequestBody PlatoRequestDTO plato){
        return new ResponseEntity<> (platoService.ingredienteConMasCalorias(plato), HttpStatus.OK);
    }

}
