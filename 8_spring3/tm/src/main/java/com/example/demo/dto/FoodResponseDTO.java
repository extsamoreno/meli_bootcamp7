package com.example.demo.dto;

import lombok.Data;

import java.util.List;

@Data
public class FoodResponseDTO {

    private double totalCalories;
    private List<IngredientResponseDTO> ingredientsCalories;
    private IngredientResponseDTO mostCaloric;
}
