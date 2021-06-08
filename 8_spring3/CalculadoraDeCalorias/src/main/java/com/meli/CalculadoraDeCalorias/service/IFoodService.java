package com.meli.CalculadoraDeCalorias.service;

import com.meli.CalculadoraDeCalorias.service.DTO.FoodDTO;
import com.meli.CalculadoraDeCalorias.service.DTO.FoodResponseDTO;

import java.util.ArrayList;

public interface IFoodService {
    FoodResponseDTO process(FoodDTO food);
    ArrayList<FoodResponseDTO> processBatch(ArrayList<FoodDTO> foodList);
}
