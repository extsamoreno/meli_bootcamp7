package com.example.APIProduct.controller;

import com.example.APIProduct.repository.Food;
import com.example.APIProduct.services.IFoodService;
import com.example.APIProduct.services.dto.FoodResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/food/")
public class FoodController {

    @Autowired
    IFoodService iFoodService;

    @PostMapping("/{food}")
    public FoodResponseDTO getByFood(@RequestBody Food food){
        return iFoodService.getTotalCalories(food);
    }

}
