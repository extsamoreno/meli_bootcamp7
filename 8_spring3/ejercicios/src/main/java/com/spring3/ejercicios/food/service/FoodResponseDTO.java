package com.spring3.ejercicios.food.service;

import com.spring3.ejercicios.food.Ingredient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodResponseDTO {

    private int totalCalories;
    private ArrayList<Ingredient> ingredientsFullResponse;
    private Ingredient maxCaloriesIngredient;

}
