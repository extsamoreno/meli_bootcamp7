package com.meli.API_calorie_calculator.repositories;

import com.meli.API_calorie_calculator.service.dto.Ingredient;

public interface Repository {
    Ingredient findIngredientByName(String name);
}
