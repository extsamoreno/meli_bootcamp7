package com.example.APIProduct.services.mapper;

import com.example.APIProduct.repository.Ingredient;
import com.example.APIProduct.services.dto.IngredientDTO;

public class IngredientMapper {
    public static IngredientDTO toDTO(Ingredient ingredient, int calories){
        return new IngredientDTO(ingredient.getName(), ingredient.getPeso()*calories);
    }

    public static Ingredient toIngrediet(IngredientDTO ingredientDTO, int peso){
        return new Ingredient(ingredientDTO.getName(), ingredientDTO.getCalories()/peso);
    }
}
