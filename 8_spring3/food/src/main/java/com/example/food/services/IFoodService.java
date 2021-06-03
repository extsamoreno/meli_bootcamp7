package com.example.food.services;

import com.example.food.services.dto.FoodDTO;
import com.example.food.services.dto.FoodResponseDTO;

import java.util.ArrayList;

public interface IFoodService {
    FoodResponseDTO process(FoodDTO food);
    ArrayList<FoodResponseDTO> processBatch(ArrayList<FoodDTO> foodList);
}
