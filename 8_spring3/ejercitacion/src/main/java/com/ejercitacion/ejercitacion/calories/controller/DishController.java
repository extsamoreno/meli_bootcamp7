package com.ejercitacion.ejercitacion.calories.controller;

import com.ejercitacion.ejercitacion.calories.dto.DishDTO;
import com.ejercitacion.ejercitacion.calories.dto.DishDataDTO;
import com.ejercitacion.ejercitacion.calories.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/dishes/")
public class DishController {

    @Autowired
    private DishService dishService;

    @PostMapping("/data")
    public ResponseEntity<DishDataDTO> getDishData(@RequestBody DishDTO dish) {
       return ResponseEntity.ok(dishService.calculateDishData(dish));
    }

    @PostMapping("/multiple/data")
    public ResponseEntity<List<DishDataDTO>> getMultipleDishesData(@RequestBody ArrayList<DishDTO> dishes) {
        return ResponseEntity.ok(dishService.calculateMultipleDishes(dishes));
    }
}
