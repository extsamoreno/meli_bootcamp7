package com.spring3.demo.Objects.Mapper;

import com.spring3.demo.Objects.DTO.IngredientDTO;
import com.spring3.demo.Objects.DTO.IngredientInput;
import com.spring3.demo.Objects.Ingredient;

public class IngredientMapper {

    public static IngredientDTO toIngredientDTO(Ingredient ingredient){
        return new IngredientDTO(ingredient.getName(), ingredient.getCalories());
    }

    public static Ingredient toIngredient(IngredientDTO ingredientDTO){
        return new Ingredient(ingredientDTO.getName(), ingredientDTO.getCalories());
    }

}
