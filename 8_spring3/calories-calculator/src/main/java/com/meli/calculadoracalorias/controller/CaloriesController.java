package com.meli.calculadoracalorias.controller;

import com.meli.calculadoracalorias.domain.Dish;
import com.meli.calculadoracalorias.service.ICaloriesService;
import com.meli.calculadoracalorias.service.dto.DishDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/calculate-calories")
public class CaloriesController {

    @Autowired
    ICaloriesService caloriesService;

    @PostMapping("/dish")
    public ResponseEntity<DishDTO> dishData(@RequestBody Dish dish) {
        return new ResponseEntity<>(caloriesService.getDishData(dish), HttpStatus.OK);
    }

    @PostMapping("/dishes")
    public ResponseEntity<List<DishDTO>> dishesData(@RequestBody List<Dish> dishes) {
        return new ResponseEntity<>(caloriesService.getDishesData(dishes), HttpStatus.OK);
    }

}
