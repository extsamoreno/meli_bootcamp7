package com.example.demo.DTO;

import com.example.demo.classes.Ingredient;
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