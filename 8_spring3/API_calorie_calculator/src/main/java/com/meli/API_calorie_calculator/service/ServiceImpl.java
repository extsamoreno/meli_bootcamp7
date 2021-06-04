package com.meli.API_calorie_calculator.service;

import com.meli.API_calorie_calculator.repositories.RepositoryImpl;
import com.meli.API_calorie_calculator.service.dto.*;
import com.meli.API_calorie_calculator.service.mapper.IngredientMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

@org.springframework.stereotype.Service
public class ServiceImpl implements Service{

    @Autowired
    private RepositoryImpl repository;

    @Override
    public FoodResDTO returnFoodResDTO (FoodDTO foodDTO) {
        FoodResDTO foodResReturn = new FoodResDTO();
        foodResReturn.setName(foodDTO.getName());
        foodResReturn.setIngredients(new ArrayList<>());
        ArrayList<IngredientDTO> ingredientDTOS = foodDTO.getIngredients();
        System.out.println(ingredientDTOS);
        int weight = 0;
        int totalCalories = 0;
        for (IngredientDTO ingredient: ingredientDTOS) {
            Ingredient ingredientDB = repository.findIngredientByName(ingredient.getName());
            IngredientResDTO ingredientResDTO = IngredientMapper.toIngredientResDTO(ingredientDB, ingredient.getWeight());
            foodResReturn.getIngredients().add(ingredientResDTO);
            totalCalories = totalCalories + ingredientResDTO.getTotalcalories();
        }
        for (IngredientResDTO ingredient: foodResReturn.getIngredients()) {
            if (ingredient.getTotalcalories() > weight) {
                weight = ingredient.getTotalcalories();
                foodResReturn.setIngredientBigger(ingredient);
            }
        }
        foodResReturn.setTotalCalories(totalCalories);
        return foodResReturn;
    }

    public SeveralFoodsResDTO returnSeveralResFood(SeveralFoodsDTO severalFoodsDTO) {
        SeveralFoodsResDTO severalFoodsResDTO = new SeveralFoodsResDTO();
        severalFoodsResDTO.setSeveralFoods(new ArrayList<>());
        for (FoodDTO foodDTO: severalFoodsDTO.getSeveralFoods()) {
            severalFoodsResDTO.getSeveralFoods().add(returnFoodResDTO(foodDTO));
        }
        return severalFoodsResDTO;
    }
}
