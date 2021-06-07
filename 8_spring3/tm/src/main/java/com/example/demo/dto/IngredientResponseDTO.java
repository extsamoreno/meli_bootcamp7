package com.example.demo.dto;

import lombok.Data;

@Data
public class IngredientResponseDTO {

    private String name;
    private double calories;

    public IngredientResponseDTO(String name, double caloriesIng) {
        this.name = name;
        this.calories = caloriesIng;

    }

    public IngredientResponseDTO() {
    }
}
