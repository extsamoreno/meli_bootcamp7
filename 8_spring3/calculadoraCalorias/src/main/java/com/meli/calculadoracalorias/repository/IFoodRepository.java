package com.meli.calculadoracalorias.repository;

import com.meli.calculadoracalorias.service.dto.IngredientDTO;

public interface IFoodRepository {
    public IngredientDTO findIngredientByName(String name);
}
