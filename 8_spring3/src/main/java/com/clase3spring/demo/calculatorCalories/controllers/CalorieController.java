package com.clase3spring.demo.calculatorCalories.controllers;

import com.clase3spring.demo.calculatorCalories.models.*;
import com.clase3spring.demo.calculatorCalories.services.ICalorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("calories")
public class CalorieController {

    @Autowired
    private ICalorieService calorieService;


    @PostMapping("/totalCalories")
    public ResponseEntity<TotalCaloriesDTO> calculateTotalCalories(@RequestBody Meal meal){
        return (new ResponseEntity<>(calorieService.calculateTotalCalories(meal), HttpStatus.OK));
    }

    @PostMapping("/ingredientCalories")
    public ResponseEntity<IngredientCalorieDTO> calculateCaloriesPerIngredient(@RequestBody Meal meal){
        return (new ResponseEntity<>(calorieService.calculateCaloriesPerIngredient(meal), HttpStatus.OK));
    }

    @PostMapping("/mostCaloricIngredient")
    public ResponseEntity<CalorieDTO> mostCaloricIngredient(@RequestBody Meal meal){
        return (new ResponseEntity<>(calorieService.mostCaloricIngredient(meal), HttpStatus.OK));
    }

    @PostMapping("/processMeal")
    public ResponseEntity<ArrayList<MealDTO>> processMeal (@RequestBody ArrayList<Meal> meals) {
        return (new ResponseEntity<>(calorieService.processMeal(meals), HttpStatus.OK));
    }

}
