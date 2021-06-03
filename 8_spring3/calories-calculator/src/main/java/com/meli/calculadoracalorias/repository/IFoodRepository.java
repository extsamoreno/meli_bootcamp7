package com.meli.calculadoracalorias.repository;

import com.meli.calculadoracalorias.service.dto.IngredientDTO;

public interface IFoodRepository {
    IngredientDTO findIngredientByName(String name);
}
