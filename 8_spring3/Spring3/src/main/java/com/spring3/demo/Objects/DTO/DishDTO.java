package com.spring3.demo.Objects.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DishDTO {
    private float totalCalories;
    private ArrayList<IngredientDTO> listIngredients;
    private IngredientDTO mostCaloriesIngredient;
}
