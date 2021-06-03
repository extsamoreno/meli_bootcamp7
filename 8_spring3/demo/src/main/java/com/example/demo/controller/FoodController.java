package com.example.demo.controller;

import com.example.demo.repository.Dish;
import com.example.demo.service.IFoodService;
import com.example.demo.repository.Ingredients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class FoodController {

    @Autowired
    IFoodService iFoodService;

    @PostMapping("/save/dish")
    public ResponseEntity<Dish> saveDish(@RequestBody Dish dishDTO){
        System.out.println("hola");
        iFoodService.saveDish(dishDTO);
        return new ResponseEntity<>(dishDTO, HttpStatus.CREATED);
    }

    @GetMapping("/{dish}")
    public ResponseEntity<?> getTotalCalories(@PathVariable("dish") String name){
        return new ResponseEntity<>(iFoodService.getCaloriesFromDish(iFoodService.getDishFromName(name)), HttpStatus.OK);
    }

    @GetMapping("/{dish}/ingredients")
    public ResponseEntity<?> getEachCalories(@PathVariable("dish") String name){
        return new ResponseEntity<>(iFoodService.getEachCalories(iFoodService.getDishFromName(name)), HttpStatus.OK);
    }

    @GetMapping("/{dish}/mostCaloricIngredient")
    public ResponseEntity<?> getMostCaloricItem(@PathVariable("dish") String name){
        return new ResponseEntity<>(iFoodService.getMostCalories(iFoodService.getDishFromName(name)), HttpStatus.OK);
    }

}
