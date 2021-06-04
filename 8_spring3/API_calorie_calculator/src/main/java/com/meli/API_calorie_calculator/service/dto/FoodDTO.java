package com.meli.API_calorie_calculator.service.dto;

import lombok.*;

import java.util.ArrayList;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FoodDTO {
    private String name;
    private ArrayList<IngredientDTO> ingredients;
}
