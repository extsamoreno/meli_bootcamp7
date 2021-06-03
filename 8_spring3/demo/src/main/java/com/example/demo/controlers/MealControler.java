package com.example.demo.controlers;

import com.example.demo.dto.MealDTO;
import com.example.demo.dto.FoodCaloriesDTO;
import com.example.demo.dto.MealsDTO;
import com.example.demo.service.IMealService;
import com.example.demo.service.IMealsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/food")
public class MealControler {

    @GetMapping("/ping")
    public String status(){
        final String pong = "pong";
        return pong;
    }

    @Autowired
    private IMealService mealService;
     @Autowired
    private IMealsService mealsService;


    @PostMapping("/meal")
    public ResponseEntity<FoodCaloriesDTO> getCalories(@RequestBody MealDTO meal){
        return  new ResponseEntity<>(mealService.getCalories(meal), HttpStatus.OK);
    }

    @PostMapping("/meals")
    public ResponseEntity<List<FoodCaloriesDTO>> getCalories(@RequestBody MealsDTO meals){
        return  new ResponseEntity<>(mealsService.getMealsCalories(meals.getMeals()), HttpStatus.OK);
    }

}
