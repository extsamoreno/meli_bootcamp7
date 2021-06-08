package com.meli.CalculadoraDeCalorias.controller;

import com.meli.CalculadoraDeCalorias.service.DTO.FoodDTO;
import com.meli.CalculadoraDeCalorias.service.DTO.FoodResponseDTO;
import com.meli.CalculadoraDeCalorias.service.IFoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/food")
public class FoodController {

    @Autowired
    IFoodService foodService;

    @PostMapping("/calculate")
    public FoodResponseDTO calculate(@RequestBody FoodDTO food){
        return foodService.process(food);
    }

    @PostMapping("/calculateBatch")
    public ArrayList<FoodResponseDTO> calculateBatch(@RequestBody ArrayList<FoodDTO> food){
        return foodService.processBatch(food);
    }
}
