package com.meli.CalculadoraDeCalorias.repository;

import com.meli.CalculadoraDeCalorias.service.DTO.IngredientDTO;

public interface IIngredientRepository {
    IngredientDTO searchByName(String name);
}
