package com.meli.calories.repository;

import com.meli.calories.service.dto.IngredientDTO;

public interface IFoodRepository {
    public IngredientDTO findIngredientByName(String name);
}
