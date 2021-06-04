package com.meli.API_calorie_calculator.controller;

import com.meli.API_calorie_calculator.service.ServiceImpl;
import com.meli.API_calorie_calculator.service.dto.FoodDTO;
import com.meli.API_calorie_calculator.service.dto.FoodResDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/foods")
public class FoodController {

    @Autowired
    private ServiceImpl service;

    @PostMapping("/calculate")
    public FoodResDTO calculateFood(@RequestBody FoodDTO foodDTO) {
        System.out.println("foodDTO = " + foodDTO);
        return service.returnFoodResDTO(foodDTO);
    }
}
