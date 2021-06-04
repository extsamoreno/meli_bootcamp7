package com.meli.caloriescalculator.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class DishDTO {

    private String name;
    private double totalCalories;
    private List<IngredientDTO> ingredients;
    private IngredientDTO maxCalories;

}
