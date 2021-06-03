package com.spring.exercise.food.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DishDTO {
    private String name;
    private double totalCalories;
    private List<IngredientDTO> ingredients;
    private IngredientDTO maxCalories;
}
