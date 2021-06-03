package com.example.food.services.dto;

import lombok.*;
import java.util.ArrayList;

@Getter
@Setter
public class FoodResponseDTO extends FoodDTO {
    private double calories;
    private IngredientsDTO biggest;

    public FoodResponseDTO(String name, ArrayList<IngredientsDTO> ingredients) {
        super(name, ingredients);
    }
}
