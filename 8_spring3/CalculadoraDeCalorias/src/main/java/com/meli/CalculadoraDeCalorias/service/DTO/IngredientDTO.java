package com.meli.CalculadoraDeCalorias.service.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter
@NoArgsConstructor
@AllArgsConstructor
public class IngredientDTO {
    private String name;
    private int quant;
    private double calories;
}
