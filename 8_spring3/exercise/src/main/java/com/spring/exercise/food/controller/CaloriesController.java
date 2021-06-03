package com.spring.exercise.food.controller;

import com.spring.exercise.food.model.Dish;
import com.spring.exercise.food.model.dto.DishDTO;
import com.spring.exercise.food.service.ICaloriesService;
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
