package com.example.demo.service.dto;

import lombok.Data;

import java.util.List;

@Data

public class FoodCaloriesDTO {

    private double totalCalories;
    private List<IngredientRespDTO> ingredients;
    private IngredientRespDTO maxCalIngredient;

}
