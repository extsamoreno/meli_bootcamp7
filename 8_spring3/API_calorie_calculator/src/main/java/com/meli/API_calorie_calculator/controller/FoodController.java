package com.meli.API_calorie_calculator.controller;

import com.meli.API_calorie_calculator.service.ServiceImpl;
import com.meli.API_calorie_calculator.service.dto.FoodDTO;
import com.meli.API_calorie_calculator.service.dto.FoodResDTO;
import com.meli.API_calorie_calculator.service.dto.SeveralFoodsDTO;
import com.meli.API_calorie_calculator.service.dto.SeveralFoodsResDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/foods")
public class FoodController {

    @Autowired
    private ServiceImpl service;

    @GetMapping("/")
    public ResponseEntity<String> getMain() {
        String message = "Welcomer to the API Food Calorie Calculator";
        return new ResponseEntity<>(message, HttpStatus.ACCEPTED);
    }

    @PostMapping("/calculateOneFood")
    public ResponseEntity<FoodResDTO> calculateFood(@RequestBody FoodDTO foodDTO) {
        return new ResponseEntity<>(service.returnFoodResDTO(foodDTO), HttpStatus.ACCEPTED);
    }

    @PostMapping("/calculateSeveralFoods")
    public ResponseEntity<SeveralFoodsResDTO> calculateSeveralFoods(@RequestBody SeveralFoodsDTO severalFoodsDTO) {
        return new ResponseEntity<>(service.returnSeveralResFood(severalFoodsDTO), HttpStatus.ACCEPTED);
    }

}
