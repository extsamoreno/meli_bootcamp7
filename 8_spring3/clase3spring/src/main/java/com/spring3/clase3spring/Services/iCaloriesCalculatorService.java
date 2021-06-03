package com.spring3.clase3spring.Services;

import com.spring3.clase3spring.Entities.*;

import java.util.ArrayList;

public interface iCaloriesCalculatorService {

    TotalCaloriesDTO calculateTotalCalories (Meal meal);
    IngredientCalorieDTO calculateCaloriesPerIngredient (Meal meal);
    CaloriesDTO mostCaloricIngredient(Meal meal);
    ArrayList<MealDTO> processMeal (ArrayList<Meal> meals);
}
