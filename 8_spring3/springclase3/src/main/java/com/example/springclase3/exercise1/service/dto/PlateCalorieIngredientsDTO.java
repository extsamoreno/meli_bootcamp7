package com.example.springclase3.exercise1.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Setter
@Getter
@AllArgsConstructor
public class PlateCalorieIngredientsDTO {

    private String name;
    private ArrayList<IngredientDTO> ingredientDTOs;
}
