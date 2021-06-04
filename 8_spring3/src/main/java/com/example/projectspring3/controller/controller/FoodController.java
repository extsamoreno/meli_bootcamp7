package com.example.projectspring3.controller.controller;

import com.example.projectspring3.controller.repository.Dish;
import com.example.projectspring3.controller.repository.IFoodService;
import com.example.projectspring3.controller.repository.IIngredientsRepository;
import com.example.projectspring3.controller.repository.IngredientsRepository;
import com.example.projectspring3.controller.service.CaloriesDTO;
import com.example.projectspring3.controller.service.CaloriesResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/food/")



public class FoodController {
    @Autowired
    IFoodService iFoodService;



    @PostMapping("/save")
    public ResponseEntity<Dish> saveDish(@RequestBody Dish dish){
        iFoodService.saveDish(dish);
        return new ResponseEntity<>(dish, HttpStatus.CREATED);
    }

    @GetMapping("/calories/dish/{nombre}")
    public ResponseEntity<CaloriesResponse> getCaloriesDish(@PathVariable("nombre") String nombre){
        CaloriesResponse calories = new CaloriesResponse(nombre, iFoodService.getCalDish(iFoodService.getDishByName(nombre)));
        return new ResponseEntity<>(calories, HttpStatus.OK);

    }

    @GetMapping("/calories/ingredients/{nombre}")
    public ResponseEntity<List<CaloriesResponse>> getCaloriesIngredients(@PathVariable("nombre") String nombre){

        return new ResponseEntity<>(iFoodService.getCalIngredients(iFoodService.getDishByName(nombre)), HttpStatus.OK);

    }

    @GetMapping("/calories/maxingredient/{nombre}")
    public ResponseEntity<CaloriesDTO> getMaxCalories(@PathVariable("nombre") String nombre){

        return new ResponseEntity<>(iFoodService.getMaxIngredients(iFoodService.getDishByName(nombre)), HttpStatus.OK);

    }

}
