package com.example._spring3.service;

import com.example._spring3.dto.FoodDTO;
import com.example._spring3.dto.IngredientDTO;
import com.example._spring3.dto.ResponseFoodDTO;
import com.example._spring3.dto.ResponseIngredientDTO;
import com.example._spring3.entity.Ingredient;
import com.example._spring3.repository.IFoodRepository;
import com.example._spring3.service.mapper.IngredientMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FoodService implements IFoodService{
    @Autowired
    IFoodRepository iFoodRepository;

    @Override
    public int calculateTotalCalories(FoodDTO food) {
        int totCalories = 0;
        for (IngredientDTO ingredientDTO : food.getIngredients()) {
            totCalories += iFoodRepository.getIngredientByName(ingredientDTO.getName()).getCalories() * ingredientDTO.getWeight();
        }
        return totCalories;
    }

    @Override
    public List<Ingredient> calculateCalIngredients(FoodDTO food) {
        List<Ingredient> respIngredients = new ArrayList<>();
        for (IngredientDTO ingredient : food.getIngredients()) {
            Ingredient auxIngredient = iFoodRepository.getIngredientByName(ingredient.getName());
            respIngredients.add(new Ingredient(auxIngredient.getName(), auxIngredient.getCalories() * ingredient.getWeight()));
        }
        return respIngredients;
    }

    @Override
    public Ingredient getMostCalIngredient(FoodDTO food) {
        Ingredient result = null;
        int mostCalories = 0;

        for (IngredientDTO ingredient : food.getIngredients()) {
            Ingredient auxIngredient = iFoodRepository.getIngredientByName(ingredient.getName());
            if(auxIngredient.getCalories() * ingredient.getWeight() > mostCalories)
            {
                result = new Ingredient(auxIngredient.getName(), auxIngredient.getCalories() * ingredient.getWeight());
                mostCalories = auxIngredient.getCalories();
            }
        }

        return result;
    }
}
