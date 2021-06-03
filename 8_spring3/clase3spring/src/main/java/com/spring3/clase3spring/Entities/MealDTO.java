package com.spring3.clase3spring.Entities;

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
    private ArrayList<CaloriesDTO> listCaloriesIngredients;
    private CaloriesDTO caloriesDTO;
}