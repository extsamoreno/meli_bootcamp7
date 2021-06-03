package com.spring.exercise.food.repository;

import com.spring.exercise.food.model.dto.IngredientDTO;

public interface IFoodRepository {
    public IngredientDTO findIngredientByName(String name);
}
