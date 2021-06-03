package com.ejercitacion.ejercitacion.calories.service;

import com.ejercitacion.ejercitacion.calories.dto.CaloriesDTO;
import com.ejercitacion.ejercitacion.calories.entity.Calories;
import com.ejercitacion.ejercitacion.calories.dto.DishDTO;
import com.ejercitacion.ejercitacion.calories.dto.DishDataDTO;
import com.ejercitacion.ejercitacion.calories.dto.IngredientDTO;
import com.ejercitacion.ejercitacion.calories.repository.DishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DishServiceImpl implements DishService {

    @Autowired
    private DishRepository dishRepository;

    @Override
    public DishDataDTO calculateDishData(DishDTO dishDTO) {
        return processDish(dishDTO);
    }

    @Override
    public List<DishDataDTO> calculateMultipleDishes(List<DishDTO> dishes) {
        List<DishDataDTO> processedDishes = new ArrayList<>();
        for (DishDTO dish : dishes) {
           processedDishes.add(processDish(dish));
        }
        return processedDishes;
    }

    private DishDataDTO processDish(DishDTO dishDTO) {

        Integer totalCalories = 0;
        Integer mostCalories = 0;
        CaloriesDTO highestCaloriesIngredient = null;
        List<CaloriesDTO> listCalories = new ArrayList<>();
        for (IngredientDTO ingredient : dishDTO.getIngredientes()) {
            Calories calories = dishRepository.getById(ingredient.getName());
            totalCalories += ingredient.getWeight() * calories.getCalories() / 100;
            if (calories.getCalories() > mostCalories) {
                mostCalories = calories.getCalories();
                highestCaloriesIngredient = CaloriesMapper.toDTO(calories);
            }
            listCalories.add(CaloriesMapper.toDTO(calories).setCalories(ingredient.getWeight() * calories.getCalories() / 100));
        }
        return new DishDataDTO(totalCalories, listCalories, highestCaloriesIngredient);
    }
}
