package com.example.springclase3.exercise1.service.mapper;

import com.example.springclase3.exercise1.repository.Ingredient;
import com.example.springclase3.exercise1.repository.Plate;
import com.example.springclase3.exercise1.service.dto.CaloriesPlateDTO;
import com.example.springclase3.exercise1.service.dto.IngredientDTO;
import com.example.springclase3.exercise1.service.dto.InputIngredient;



public class PlateMapper {

    public static CaloriesPlateDTO toDTO(Plate plate){
        return new CaloriesPlateDTO(plate.getName(), plate.getPlateCalories() );
    }

    public static IngredientDTO toDTO(Ingredient ingredient){
        return new IngredientDTO(ingredient.getName(), ingredient.getCalories());
    }

    public static Ingredient toIngredient(InputIngredient inputIngredient, Integer calories) {
        return new Ingredient(inputIngredient.getName(), inputIngredient.getWeight(), calories);
    }
}
