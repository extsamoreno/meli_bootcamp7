package com.example.demo.calculadoraDeCalorias;

import com.models.*;

import java.util.ArrayList;

public interface iCaloriesCalculatorService {

    TotalCaloriesDTO calculateTotalCalories (Meal meal);
    IngredientCalorieDTO calculateCaloriesPerIngredient (Meal meal);
    CaloriesDTO mostCaloricIngredient(Meal meal);
    ArrayList<MealDTO> processMeal (ArrayList<Meal> meals);
}