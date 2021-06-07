package com.example.demo.services;


import com.example.demo.classes.Ingredient;
import com.example.demo.DTO.FoodDTO;
import com.example.demo.DTO.IngredientDTO;
import com.example.demo.DTO.ResponseFoodDTO;
import com.example.demo.repositories.interfaces.IFoodRepository;
import com.example.demo.services.interfaces.IFoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FoodService implements IFoodService {

    @Autowired
    IFoodRepository iFoodRepository;

    @Override
    public ResponseFoodDTO getCalories(FoodDTO foodDTO) {
        ResponseFoodDTO responseFoodDTO = new ResponseFoodDTO();
        int totalCalories = 0;
        int maxCalories = -1;
        int calories;
        List<Ingredient> list = new ArrayList<>();
        Ingredient ingredient;

        for(IngredientDTO ing : foodDTO.getIngredients()) {
            ingredient = iFoodRepository.findIngredientByName(ing.getName());
            ingredient.setCalories((int)(ingredient.getCalories() * ing.getWeight()));
            calories = ingredient.getCalories();
            totalCalories += calories;
            if(maxCalories < calories) {
                maxCalories = calories;
                responseFoodDTO.setMaxCaloriesIngredient(ingredient);
            }
            list.add(ingredient);
        }

        responseFoodDTO.setTotalCalories(totalCalories);
        responseFoodDTO.setIngredientsCalories(list);

        return responseFoodDTO;
    }

    @Override
    public List<ResponseFoodDTO> getPlatesCalories(FoodDTO[] foodDTO) {
        List<ResponseFoodDTO> listResponse = new ArrayList<>();
        for(FoodDTO f : foodDTO) {
            listResponse.add(getCalories(f));
        }
        return listResponse;
    }
}