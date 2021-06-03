package com.example.demo.service;

import com.example.demo.dto.DishDTO;
import com.example.demo.dto.FoodCaloriesDTO;
import com.example.demo.dto.IngredientReqDTO;
import com.example.demo.dto.IngredientRespDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DishService implements IDishService {
    @Override
    public FoodCaloriesDTO getCalories(DishDTO dish){

        FoodCaloriesDTO foodResponse = new FoodCaloriesDTO();
        List<IngredientRespDTO> ingredientResp = new ArrayList<>();

        double totalCalories = 0.0;
        IngredientRespDTO max = new IngredientRespDTO( "", 0.0);

        for(IngredientReqDTO ing: dish.getIngridients()){

            double caloriesIng = ing.getWeight() * 1;
            totalCalories += caloriesIng;

            IngredientRespDTO ingResp = new IngredientRespDTO( ing.getName(), caloriesIng);

            if (max.getCalories() < caloriesIng){
                max = ingResp;
            }

            ingredientResp.add(ingResp);

        }

        foodResponse.setTotalCalories(totalCalories);
        foodResponse.setMaxCalIngredient(max);
        foodResponse.setIngredients(ingredientResp);

        return foodResponse;
    }
}
