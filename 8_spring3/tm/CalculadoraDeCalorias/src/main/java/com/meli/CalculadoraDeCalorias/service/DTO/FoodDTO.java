package com.meli.CalculadoraDeCalorias.service.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class FoodDTO {
    private String name;
    private ArrayList<IngredientDTO> ingredients;
}
