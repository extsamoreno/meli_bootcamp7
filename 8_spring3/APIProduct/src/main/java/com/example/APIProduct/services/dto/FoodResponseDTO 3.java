package com.example.APIProduct.services.dto;

import com.example.APIProduct.repository.Ingredient;
import lombok.*;

import java.util.HashMap;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodResponseDTO {
    private String name;
    private int totalCalories;
    private List<IngredientDTO> listCaloriesIng;
    private IngredientDTO maxCaloriesIngredient;

}
