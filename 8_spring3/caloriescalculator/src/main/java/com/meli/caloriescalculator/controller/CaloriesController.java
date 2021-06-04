package com.meli.caloriescalculator.controller;

import com.meli.caloriescalculator.dto.DishDTO;
import com.meli.caloriescalculator.entity.Dish;
import com.meli.caloriescalculator.service.ICaloriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CaloriesController {

    @Autowired
    ICaloriesService caloriesService;

    @PostMapping("/dish")
    public ResponseEntity<DishDTO> dishData(@RequestBody Dish dish) {
        return new ResponseEntity<>(caloriesService.getDishData(dish), HttpStatus.OK);
    }

}
