package com.spring3.ejercicios.food.service;

import com.spring3.ejercicios.food.IngredientDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodDTO {
    private String name;
    private ArrayList<IngredientDTO> ingredients;

}
