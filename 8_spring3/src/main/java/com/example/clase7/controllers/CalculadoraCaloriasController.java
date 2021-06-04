package com.example.clase7.controllers;

import com.example.clase7.dto.IngredienteResponseDTO;
import com.example.clase7.dto.PlatoProcesadoResponseDTO;
import com.example.clase7.dto.PlatoRequestDTO;
import com.example.clase7.dto.PlatoResponseDTO;
import com.example.clase7.services.PlatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/calculadora")
public class CalculadoraCaloriasController {
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

    @PostMapping("/platosProcesados")
    public ResponseEntity<ArrayList<PlatoProcesadoResponseDTO>> platosProcesados (@RequestBody PlatoRequestDTO[] platos){
        return new ResponseEntity<> (platoService.platosProcesados(platos), HttpStatus.OK);
    }
}