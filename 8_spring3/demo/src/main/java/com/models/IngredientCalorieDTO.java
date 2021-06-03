package com.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class IngredientCalorieDTO {

    private Meal meal;
    private ArrayList<CaloriesDTO> listCaloriesIngredients;
}
