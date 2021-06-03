package com.example.demo.controlers;

import com.example.demo.service.DishService;
import com.example.demo.service.dto.DishDTO;
import com.example.demo.service.dto.FoodCaloriesDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/food")
public class FoodControler {


    @Autowired
    private IDishService IDishService;

    @PostMapping
    public FoodCaloriesDTO getCalories(@RequestBody DishDTO dish){

        FoodCaloriesDTO response = IDishService.getCalories(dish);

        return  response;
    }

}
