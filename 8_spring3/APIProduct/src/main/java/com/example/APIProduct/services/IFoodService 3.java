package com.example.APIProduct.services;

import com.example.APIProduct.repository.Food;
import com.example.APIProduct.services.dto.FoodResponseDTO;
import org.springframework.stereotype.Service;


public interface IFoodService {
    FoodResponseDTO getTotalCalories(Food food);
}
