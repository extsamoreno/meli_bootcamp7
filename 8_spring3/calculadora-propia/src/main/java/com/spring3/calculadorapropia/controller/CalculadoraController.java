package com.spring3.calculadorapropia.controller;

import com.spring3.calculadorapropia.service.dtos.FoodRequestDTO;
import com.spring3.calculadorapropia.service.CalculadoraService;
import com.spring3.calculadorapropia.service.dtos.FoodResponseDTO;
import com.spring3.calculadorapropia.service.dtos.IngredientResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/calories")

public class CalculadoraController {
    @Autowired
    private CalculadoraService calculadoraService;

    @PostMapping("/total")
    public ResponseEntity<FoodResponseDTO> calculateCalories (@RequestBody FoodRequestDTO foodRequestDTO) {
        return new ResponseEntity<>(calculadoraService.getCalories(foodRequestDTO), HttpStatus.OK);
    }

    @PostMapping("/ingredients")
    public ResponseEntity<HashMap<String, Integer>> caloriesPerIngredient (@RequestBody FoodRequestDTO foodRequestDTO) {
        return new ResponseEntity<>(calculadoraService.getIngredients(foodRequestDTO), HttpStatus.OK) ;
    }

    @PostMapping("/fatestIngredient")
    public ResponseEntity<IngredientResponseDTO> fatestIngredient (@RequestBody FoodRequestDTO foodRequestDTO) {
        return new ResponseEntity<>(calculadoraService.getFatestIngredient(foodRequestDTO), HttpStatus.OK) ;
    }
}
