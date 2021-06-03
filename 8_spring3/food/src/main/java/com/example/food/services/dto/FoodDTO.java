package com.example.food.services.dto;

import lombok.*;

import java.util.ArrayList;

@Getter
@Setter
public class FoodDTO {
    String name;
    ArrayList<IngredientsDTO> ingredients;

    public FoodDTO(String name, ArrayList<IngredientsDTO> ingredients) {
        this.name = name;
        this.ingredients = ingredients;
    }
}
