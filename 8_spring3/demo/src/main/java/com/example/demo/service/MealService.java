package com.example.demo.service;

import com.example.demo.dto.MealDTO;
import com.example.demo.dto.FoodCaloriesDTO;
import com.example.demo.dto.IngredientReqDTO;
import com.example.demo.dto.IngredientRespDTO;
import com.example.demo.repository.IFoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MealService implements IMealService {
    @Autowired
    private IFoodRepository foodRepository;

    @Override
    public FoodCaloriesDTO getCalories(MealDTO dish){

        FoodCaloriesDTO foodResponse = new FoodCaloriesDTO();
        List<IngredientRespDTO> ingredientResp = new ArrayList<>();

        double totalCalories = 0.0;
        IngredientRespDTO max = new IngredientRespDTO( "", 0.0);

        for(IngredientReqDTO ing: dish.getIngredients()){

            double caloriesIng = ing.getWeight() * foodRepository.findIngredientByName(ing.getName()).getCalories() / 100;
            System.out.println("foodRepository.findIngredienteByName(ing.getName()) = "
                    + foodRepository.findIngredientByName(ing.getName()).toString());
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
