package com.meli.API_calorie_calculator.service;

import com.meli.API_calorie_calculator.service.dto.FoodDTO;
import com.meli.API_calorie_calculator.service.dto.FoodResDTO;

public interface Service {
    FoodResDTO returnFoodResDTO (FoodDTO foodDTO);
}
