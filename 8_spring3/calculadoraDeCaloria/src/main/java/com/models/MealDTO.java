package com.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MealDTO {

    private Meal meal;
    private Integer totalCalories;
    private ArrayList<CaloriesDTO> listCaloriesIngredients;
    private CaloriesDTO caloriesDTO;
}
