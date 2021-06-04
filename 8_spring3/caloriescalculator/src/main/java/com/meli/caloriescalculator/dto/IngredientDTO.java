package com.meli.caloriescalculator.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class IngredientDTO {

    private String name;
    private double calories;

}
