package com.example.demo.calculadora.controller;

import com.example.demo.calculadora.Dish;
import com.example.demo.calculadora.service.IDishService;
import com.example.demo.calculadora.service.dto.DishDTO;
import com.example.demo.calculadora.service.dto.IngredientsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dish")

public class DishController {
    @Autowired
    IDishService iDishService;
    @GetMapping("/total-calories")
    public ResponseEntity<DishDTO> calculateCalories (@RequestBody Dish dish) {
        return new ResponseEntity<DishDTO>(iDishService.totalCalories(dish), HttpStatus.OK);
    }
    @GetMapping("/ingredients-calories")
    public ResponseEntity<DishDTO> ingredientsCalories (@RequestBody Dish dish) {
        return new ResponseEntity<DishDTO>(iDishService.ingredientsCalories(dish), HttpStatus.OK);
    }
    @GetMapping("/more-calories")
    public ResponseEntity<IngredientsDTO> moreCalories (@RequestBody Dish dish) {
        return new ResponseEntity<IngredientsDTO>(iDishService.moreCalories(dish), HttpStatus.OK);
    }


}
