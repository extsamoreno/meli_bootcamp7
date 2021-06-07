package com.example.demo.service;

import com.example.demo.dto.DishDTO;
import com.example.demo.dto.FoodResponseDTO;
import com.example.demo.dto.IngredientDTO;
import com.example.demo.dto.IngredientResponseDTO;
import com.example.demo.repository.IFoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
public class FoodService {

    @Autowired
    private IFoodRepository IFoodRepository;

    public List<FoodResponseDTO> getMultipleDishesCalories(List<DishDTO> dishDTOList) throws FileNotFoundException {

        List<FoodResponseDTO> foodResponseDTOList = new ArrayList<>();

        for(DishDTO d : dishDTOList){
            foodResponseDTOList.add(getCalories(d));
        }

        return foodResponseDTOList;
    }


    public FoodResponseDTO getCalories(DishDTO dishDTO) throws FileNotFoundException {

        FoodResponseDTO foodResponse = new FoodResponseDTO();
        List<IngredientResponseDTO> ingredientResponseDTOS = new ArrayList<>();

        double totalCalories = 0.0;
        IngredientResponseDTO max = new IngredientResponseDTO();

        for (IngredientDTO i : dishDTO.getIngredients()) {

            double calories = IFoodRepository.getIngredientByName(i.getName()).getCalories() * i.getWeight() / 100;
            totalCalories += calories;

            IngredientResponseDTO ingredientResponseDTO = new IngredientResponseDTO(i.getName(), calories);

            if (max.getCalories() < calories) {
                max = ingredientResponseDTO;
            }

            ingredientResponseDTOS.add(ingredientResponseDTO);
        }
        foodResponse.setTotalCalories(totalCalories);
        foodResponse.setMostCaloric(max);
        foodResponse.setIngredientsCalories(ingredientResponseDTOS);

        return foodResponse;
    }
}
