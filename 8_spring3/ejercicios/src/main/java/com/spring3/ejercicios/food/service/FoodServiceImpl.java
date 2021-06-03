package com.spring3.ejercicios.food.service;

import com.spring3.ejercicios.food.Ingredient;
import com.spring3.ejercicios.food.IngredientDTO;
import com.spring3.ejercicios.food.repository.IFoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class FoodServiceImpl implements IFoodService {

    @Autowired
    IFoodRepository foodRepository;

    @Override
    public FoodResponseDTO responseFoodDTO(FoodDTO foodDTO) {
        FoodResponseDTO foodResponseDTO = new FoodResponseDTO();

        int totalCalories = 0;
        int maxCalories = 0;
        Ingredient maxCaloriesIngredient = new Ingredient();
        ArrayList<Ingredient> ingredientsCalories = new ArrayList<>();

        for (IngredientDTO ing : foodDTO.getIngredients()) {
            totalCalories += ing.getWeight() * foodRepository.findIngredientByName(ing.getName()).getCalories();
            ingredientsCalories.add(foodRepository.findIngredientByName(ing.getName()));
            int actualMaxCalories = foodRepository.findIngredientByName(ing.getName()).getCalories();
            if (maxCalories < actualMaxCalories) {
                maxCalories = actualMaxCalories;
                maxCaloriesIngredient = foodRepository.findIngredientByName(ing.getName());
            }
        }

        foodResponseDTO.setTotalCalories(totalCalories);
        foodResponseDTO.setIngredientsFullResponse(ingredientsCalories);
        foodResponseDTO.setMaxCaloriesIngredient(maxCaloriesIngredient);

        return foodResponseDTO;
    }
}
