package com.calculator.calculator.services;

import com.calculator.calculator.dtos.IngredientDTO;
import com.calculator.calculator.dtos.PlateDTO;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ICalculatorService {
    List<PlateDTO> calculateCaloriesByPlate(List<PlateDTO> plateDTO);
    PlateDTO calculateCaloriesByPlate(PlateDTO plateDTO);
    List<IngredientDTO> calculateCaloriesByIngredient(PlateDTO plateDTO);
    IngredientDTO calculateIngredientWithMoreCalories(PlateDTO plateDTO);
}
