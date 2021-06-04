package com.clase3spring.demo.calculatorCalories.services;

import com.clase3spring.demo.calculatorCalories.models.*;

import java.util.ArrayList;

public interface ICalorieService {

    TotalCaloriesDTO calculateTotalCalories (Meal meal);
    IngredientCalorieDTO calculateCaloriesPerIngredient (Meal meal);
    CalorieDTO mostCaloricIngredient(Meal meal);
    ArrayList<MealDTO> processMeal (ArrayList<Meal> meals);
}
