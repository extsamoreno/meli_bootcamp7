package com.spring3.calculadorapropia.service;

import com.spring3.calculadorapropia.service.dtos.FoodRequestDTO;
import com.spring3.calculadorapropia.service.dtos.FoodResponseDTO;
import com.spring3.calculadorapropia.service.dtos.IngredientResponseDTO;
import java.util.HashMap;

public interface CalculadoraService {
    FoodResponseDTO getCalories(FoodRequestDTO foodRequestDTO);
    HashMap<String, Integer> getIngredients(FoodRequestDTO foodRequestDTO);
    IngredientResponseDTO getFatestIngredient (FoodRequestDTO foodRequestDTO);
}
