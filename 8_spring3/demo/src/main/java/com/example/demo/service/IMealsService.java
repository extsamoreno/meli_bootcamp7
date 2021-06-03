package com.example.demo.service;

import com.example.demo.dto.FoodCaloriesDTO;
import com.example.demo.dto.MealDTO;

import java.util.List;

public interface IMealsService {

    public List<FoodCaloriesDTO> getMealsCalories(List<MealDTO> meals);
}
