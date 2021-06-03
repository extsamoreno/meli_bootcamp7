package com.example.demo.service;

import com.example.demo.dto.MealDTO;
import com.example.demo.dto.FoodCaloriesDTO;

//@Service
public interface IMealService {
    FoodCaloriesDTO getCalories(MealDTO dish);
}
