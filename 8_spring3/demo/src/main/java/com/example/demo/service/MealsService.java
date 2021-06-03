package com.example.demo.service;

import com.example.demo.dto.FoodCaloriesDTO;
import com.example.demo.dto.MealDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MealsService implements IMealsService{

    @Autowired
    private IMealService mealService;
    @Override
    public List<FoodCaloriesDTO> getMealsCalories(List<MealDTO> meals) {
        List<FoodCaloriesDTO> mealsCalories = new ArrayList<>();


        for( MealDTO meal: meals){
            mealsCalories.add(mealService.getCalories(meal));
        }
        return mealsCalories;
    }
}
