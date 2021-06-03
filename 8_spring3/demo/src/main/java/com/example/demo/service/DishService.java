package com.example.demo.service;

import com.example.demo.service.dto.DishDTO;
import com.example.demo.service.dto.FoodCaloriesDTO;
import com.example.demo.service.dto.IngredientReqDTO;
import com.example.demo.service.dto.IngredientRespDTO;
import org.springframework.stereotype.Service;

@Service
public class DishService implements IDishService {
    @Override
    public FoodCaloriesDTO getCalories(DishDTO dish){

        FoodCaloriesDTO response = new FoodCaloriesDTO();

        double totalCalories = 0.0;
        IngredientRespDTO max = new IngredientRespDTO( "", 0.0);

        for(IngredientReqDTO ing: dish.getIngridients()){

            double caloriesIng = ing.getWeight() * 1;
            totalCalories += caloriesIng;

            IngredientRespDTO ingResp = new IngredientRespDTO( ing.getName(), caloriesIng);

            if (max.getCalories() < caloriesIng){
                max = ingResp;
            }

            response.getIngredients().add(ingResp);

        }

        response.setTotalCalories(totalCalories);
        response.setMaxCalIngredient(max);

        return response;
    }
}
