package com.meli.calculadoracalorias.service.dto;

import java.util.List;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DishDTO {
    private String name;
    private double totalCalories;
    private List<IngredientDTO> ingredients;
    private IngredientDTO maxCalories;
}
