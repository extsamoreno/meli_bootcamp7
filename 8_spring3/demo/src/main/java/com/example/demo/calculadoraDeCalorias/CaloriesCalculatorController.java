package com.example.demo.calculadoraDeCalorias;

import com.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class CaloriesCalculatorController {

    @Autowired
    iCaloriesCalculatorService iCaloriesCalculatorService;

    @PostMapping("/totalCalories")
    public ResponseEntity<TotalCaloriesDTO> calculateTotalCalories(@RequestBody Meal meal){
        return (new ResponseEntity<>(iCaloriesCalculatorService.calculateTotalCalories(meal), HttpStatus.OK));
    }

    @PostMapping("/ingredientCalories")
    public ResponseEntity<IngredientCalorieDTO> calculateCaloriesPerIngredient(@RequestBody Meal meal){
        return (new ResponseEntity<>(iCaloriesCalculatorService.calculateCaloriesPerIngredient(meal), HttpStatus.OK));
    }

    @PostMapping("/mostCaloricIngredient")
    public ResponseEntity<CaloriesDTO> mostCaloricIngredient(@RequestBody Meal meal){
        return (new ResponseEntity<>(iCaloriesCalculatorService.mostCaloricIngredient(meal), HttpStatus.OK));
    }

    @PostMapping("/processMeal")
    public ResponseEntity<ArrayList<MealDTO>> processMeal (@RequestBody ArrayList<Meal> meals) {
        return (new ResponseEntity<>(iCaloriesCalculatorService.processMeal(meals), HttpStatus.OK));
    }



}