package com.example.food.services;

import com.example.food.services.dto.FoodDTO;
import com.example.food.services.dto.FoodResponseDTO;
import com.example.food.services.dto.IngredientsDTO;
import com.example.food.repository.IFoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class FoodServices implements IFoodService {

    @Autowired
    IFoodRepository foodRepository;

    public FoodResponseDTO process(FoodDTO food){
        FoodResponseDTO  response = new FoodResponseDTO(food.getName(),food.getIngredients());
        response.setName(food.getName());
        double totalCal = 0;
        IngredientsDTO max = null;
        for (IngredientsDTO ingredient : food.getIngredients()) {
            IngredientsDTO temp = foodRepository.searchByName(ingredient.getName());
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