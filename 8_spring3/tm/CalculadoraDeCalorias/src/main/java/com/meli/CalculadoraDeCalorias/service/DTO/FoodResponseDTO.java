package com.meli.CalculadoraDeCalorias.service.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FoodResponseDTO {
        private String name;
        private ArrayList<IngredientDTO> ingredients;
        private double calories;
        private IngredientDTO biggest;
}
