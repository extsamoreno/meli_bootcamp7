package com.spring3.spring3.PracticoMañana.DTO;

import com.spring3.spring3.PracticoMañana.Classes.Ingredient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodResponseDTO {
    private int totalCalories;
    private List<Ingredient> ingredientList;
    private Ingredient maxCaloriesIngredient;
}