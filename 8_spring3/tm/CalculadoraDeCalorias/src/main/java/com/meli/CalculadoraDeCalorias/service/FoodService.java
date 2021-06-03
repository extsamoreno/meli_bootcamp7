package com.meli.CalculadoraDeCalorias.service;

import com.meli.CalculadoraDeCalorias.repository.IIngredientRepository;
import com.meli.CalculadoraDeCalorias.service.DTO.FoodDTO;
import com.meli.CalculadoraDeCalorias.service.DTO.FoodResponseDTO;
import com.meli.CalculadoraDeCalorias.service.DTO.IngredientDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class FoodService implements IFoodService{

    @Autowired
    IIngredientRepository ingredientRepository;

    public FoodResponseDTO process(FoodDTO food){
        FoodResponseDTO  response = new FoodResponseDTO();
        response.setName(food.getName());
        double totalCal = 0;
        IngredientDTO max = null;
        for (IngredientDTO ingredient : food.getIngredients()) {
            IngredientDTO temp = ingredientRepository.searchByName(ingredient.getName());
            ingredient.setCalories(temp.getCalories()*ingredient.getQuant());
            totalCal+=ingredient.getCalories();
            if(max==null || max.getCalories()<ingredient.getCalories()){
                max=ingredient;
            }
        }
        response.setCalories(totalCal);
        response.setBiggest(max);
        response.setIngredients(food.getIngredients());

        return response;
    }

    public ArrayList<FoodResponseDTO> processBatch(ArrayList<FoodDTO> foodList) {
        ArrayList<FoodResponseDTO> response = new ArrayList<>();
        for(FoodDTO food : foodList){
            response.add(process(food));
        }
        return response;
    }
}
