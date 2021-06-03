package com.example.APIProduct.services.dto;

import com.example.APIProduct.repository.Ingredient;
import lombok.*;

import java.util.HashMap;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FoodResponseDTO {
    private String name;
    private int totalCalories;
    private HashMap<String, Integer> mapCaloriesIng;
    private Ingredient maxCaloriesIngredient;

}
