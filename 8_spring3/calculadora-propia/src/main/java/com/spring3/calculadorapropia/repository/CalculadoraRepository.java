package com.spring3.calculadorapropia.repository;

import com.spring3.calculadorapropia.service.dtos.FoodRequestDTO;
import com.spring3.calculadorapropia.service.dtos.FoodResponseDTO;
import com.spring3.calculadorapropia.service.dtos.IngredientResponseDTO;

public interface CalculadoraRepository {
    public IngredientResponseDTO findIngredientByName (String ingredient);
}
