package com.example.demo.service;

import com.example.demo.service.dto.DishDTO;
import com.example.demo.service.dto.FoodCaloriesDTO;

public interface IDishService {

    public FoodCaloriesDTO getCalories(DishDTO dish);
}
