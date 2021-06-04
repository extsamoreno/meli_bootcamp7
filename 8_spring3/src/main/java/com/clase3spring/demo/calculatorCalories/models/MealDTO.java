package com.clase3spring.demo.calculatorCalories.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MealDTO {
    private Meal meal;
    private Integer totalCalories;
    private ArrayList<CalorieDTO> listCaloriesIngredients;
    private CalorieDTO caloriesDTO;
}
