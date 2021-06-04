package com.meli.API_calorie_calculator.service;

import com.meli.API_calorie_calculator.service.dto.FoodDTO;
import com.meli.API_calorie_calculator.service.dto.FoodResDTO;
import com.meli.API_calorie_calculator.service.dto.Ingredient;

public interface Service {
    FoodResDTO returnFoodResDTO (FoodDTO foodDTO);
}
