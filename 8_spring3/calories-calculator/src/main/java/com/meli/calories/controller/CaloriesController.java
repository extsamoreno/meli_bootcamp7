package com.meli.calories.controller;

import com.meli.calories.domain.Dish;
import com.meli.calories.service.ICaloriesService;
import com.meli.calories.service.dto.DishDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculate-calories")
public class CaloriesController {

    @Autowired
    ICaloriesService caloriesService;

    @PostMapping("/dish")
    public ResponseEntity<DishDTO> dishData(@RequestBody Dish dish){
        return new ResponseEntity<>(caloriesService.getDishData(dish), HttpStatus.OK);
    }
}