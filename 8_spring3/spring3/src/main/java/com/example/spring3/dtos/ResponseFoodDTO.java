package com.example.spring3.dtos;

import com.example.spring3.classes.Ingredient;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseFoodDTO {
    private Integer totalCalories;
    private List<Ingredient> ingredientsCalories;
    private Ingredient maxCaloriesIngredient;
}
