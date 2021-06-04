package com.spring3.spring3.PracticoMañana.Service;

import com.spring3.spring3.PracticoMañana.DTO.FoodDTO;
import com.spring3.spring3.PracticoMañana.DTO.FoodResponseDTO;
import com.spring3.spring3.PracticoMañana.Classes.Ingredient;
import com.spring3.spring3.PracticoMañana.DTO.IngredientDTO;
import com.spring3.spring3.PracticoMañana.Repository.IFoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FoodService implements IFoodService {

    @Autowired
    IFoodRepository iDishRepository;

    @Override
    public FoodResponseDTO responseFoodDTO(FoodDTO foodDTO) {
        FoodResponseDTO foodResponseDTO = new FoodResponseDTO();

        int maxCalories = 0;
        int totalCalories = 0;
        Ingredient maxCaloriesIngredient = new Ingredient();
        List<Ingredient> ingredientCalories = new ArrayList<>();
        for (IngredientDTO i : foodDTO.getIngredients()) {
            totalCalories += iDishRepository.findIngredientsByName(i.getName()).getCalories() * i.getWeight();
            ingredientCalories.add(iDishRepository.findIngredientsByName(i.getName()));
            int actualMaxCalories = iDishRepository.findIngredientsByName(i.getName()).getCalories();
            if (maxCalories < actualMaxCalories) {
                maxCalories = actualMaxCalories;
                maxCaloriesIngredient = iDishRepository.findIngredientsByName(i.getName());
            }
        }

        foodResponseDTO.setIngredientList(ingredientCalories);
        foodResponseDTO.setTotalCalories(totalCalories);
        foodResponseDTO.setMaxCaloriesIngredient(maxCaloriesIngredient);
        return foodResponseDTO;
    }
}