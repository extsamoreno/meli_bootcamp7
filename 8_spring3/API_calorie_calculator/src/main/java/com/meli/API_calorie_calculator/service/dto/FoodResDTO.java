package com.meli.API_calorie_calculator.service.dto;

import lombok.*;

import java.util.ArrayList;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FoodResDTO {
    private String name;
    private int totalCalories;
    private ArrayList<IngredientResDTO> ingredients;
    private IngredientResDTO ingredientBigger;
}
