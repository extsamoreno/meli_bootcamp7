package com.meli.API_calorie_calculator.service.mapper;

import com.meli.API_calorie_calculator.service.dto.Ingredient;
import com.meli.API_calorie_calculator.service.dto.IngredientResDTO;

public class IngredientMapper {
    public static IngredientResDTO toIngredientResDTO(Ingredient ingredient, int weight) {
        return new IngredientResDTO(ingredient.getName(), weight, (ingredient.getCalories() * weight));
    }
}
