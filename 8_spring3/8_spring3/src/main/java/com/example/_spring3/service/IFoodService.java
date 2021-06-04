package com.example._spring3.service;

import com.example._spring3.dto.FoodDTO;
import com.example._spring3.dto.ResponseFoodDTO;
import com.example._spring3.dto.ResponseIngredientDTO;
import com.example._spring3.entity.Ingredient;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IFoodService {
    public int calculateTotalCalories(FoodDTO food);
    public List<Ingredient> calculateCalIngredients(FoodDTO food);
    public Ingredient getMostCalIngredient(FoodDTO food);
}
