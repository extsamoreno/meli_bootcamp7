package com.meli.API_calorie_calculator.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class IngredientResDTO {
    private String name;
    private int weight;
    private int totalcalories;
}
