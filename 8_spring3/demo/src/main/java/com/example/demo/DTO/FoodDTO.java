package com.example.demo.DTO;

import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
public class FoodDTO {
    private String name;
    private List<IngredientDTO> ingredients;
}