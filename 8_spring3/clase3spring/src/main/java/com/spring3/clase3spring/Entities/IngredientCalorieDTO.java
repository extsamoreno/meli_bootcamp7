package com.spring3.clase3spring.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class IngredientCalorieDTO {

    private Meal meal;
    private ArrayList<CaloriesDTO> listCaloriesIngredients;
}
