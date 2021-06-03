package com.example.food.controllers;

import com.example.food.services.IFoodService;
import com.example.food.services.dto.FoodDTO;
import com.example.food.services.dto.FoodResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/food")
public class FoodController {

    @Autowired
    private IFoodService foodService;

    @PostMapping("/calculate")
    public FoodResponseDTO calculate(@RequestBody FoodDTO food){
        return foodService.process(food);
    }

    @PostMapping("/calculateBatch")
    public ArrayList<FoodResponseDTO> calculateBatch(@RequestBody ArrayList<FoodDTO> food){
        return foodService.processBatch(food);
    }
}