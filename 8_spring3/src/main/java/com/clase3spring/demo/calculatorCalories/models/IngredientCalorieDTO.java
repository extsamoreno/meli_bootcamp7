package com.clase3spring.demo.calculatorCalories.models;

import java.util.ArrayList;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class IngredientCalorieDTO {
    private Meal meal;
    private ArrayList<CalorieDTO> listCaloriesIngredients;
}
