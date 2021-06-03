package com.example.APIProduct.services;

import com.example.APIProduct.repository.Food;
import com.example.APIProduct.repository.IFoodRepository;
import com.example.APIProduct.repository.Ingredient;
import com.example.APIProduct.services.dto.FoodResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


@Service
public class FoodServiceImple implements  IFoodService{

    @Autowired
    IFoodRepository iFoodRepository;

    @Override
    public FoodResponseDTO getTotalCalories(Food food) {

        List<Ingredient> listIngredients = food.getListIngredient();
        HashMap<String, Integer> mapCaloriesIng = null;

        for(Ingredient ing: listIngredients){
            mapCaloriesIng.put(ing.getName(), ing.getCalories());
        }

        FoodResponseDTO foodResult = new FoodResponseDTO(food.getName(),TotalCalories(listIngredients),mapCaloriesIng,maxCalories(listIngredients));
        return null;
    }
    public Ingredient maxCalories(List<Ingredient> list){
        Ingredient result=null;
        int aux=0;
        for(Ingredient ing: list){
            if(ing.getCalories()>aux){
                result = ing;
            }
        }
        return result;
    }

    public int TotalCalories(List<Ingredient> list){
        int sumCalories=0;
        for (Ingredient ing: list) {
            sumCalories+= ing.getCalories();
        }
        return sumCalories;
    }
}
