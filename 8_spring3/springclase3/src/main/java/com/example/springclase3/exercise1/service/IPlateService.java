package com.example.springclase3.exercise1.service;

import com.example.springclase3.exercise1.repository.Ingredient;
import com.example.springclase3.exercise1.service.dto.InputPlate;
import com.example.springclase3.exercise1.repository.Plate;
import com.example.springclase3.exercise1.service.dto.*;

import java.util.ArrayList;

public interface IPlateService {

    String savePlate(InputPlate inputPlate);

    CaloriesPlateDTO getPlateCalorieDTO(String plateName);
    PlateCalorieIngredientsDTO getPlateIngredientsCalorieDTO(String plateName);
    IngredientDTO getMostCalorieIngredientDTO(String plateName);
    Ingredient getMostCalorieIngredient(Plate plate);
    Plate getPlateByName(String plateName);
    ArrayList<Ingredient> getPlateIngredients(InputPlate inputPlate);
    Integer getPlateCalories(Plate plate);
}
