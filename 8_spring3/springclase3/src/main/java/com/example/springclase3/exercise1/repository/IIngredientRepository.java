package com.example.springclase3.exercise1.repository;

import com.example.springclase3.exercise1.service.dto.IngredientDTO;
import com.example.springclase3.exercise1.service.dto.InputIngredient;

import java.util.ArrayList;

public interface IIngredientRepository {

    IngredientDTO findCalories(Ingredient ingredient);
    Integer findIngredientCalories(InputIngredient inputIngredient);
}
