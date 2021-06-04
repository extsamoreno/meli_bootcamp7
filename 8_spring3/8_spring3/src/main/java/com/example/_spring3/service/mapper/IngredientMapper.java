package com.example._spring3.service.mapper;

import com.example._spring3.dto.ResponseIngredientDTO;
import com.example._spring3.entity.Ingredient;

import java.util.ArrayList;
import java.util.List;

public class IngredientMapper {
    public static ResponseIngredientDTO toDTO(Ingredient ing){
        return new ResponseIngredientDTO(ing.getName(), ing.getCalories());
    }

    public static List<ResponseIngredientDTO> listToDTO(List<Ingredient> ingList){
        List<ResponseIngredientDTO> resList = new ArrayList<>();
        for (Ingredient ing : ingList) {
            resList.add(new ResponseIngredientDTO(ing.getName(), ing.getCalories()));
        }
        return resList;
    }

    public static Ingredient toIngredient(ResponseIngredientDTO ing){
        return new Ingredient(ing.getName(), ing.getCalories());
    }
}
