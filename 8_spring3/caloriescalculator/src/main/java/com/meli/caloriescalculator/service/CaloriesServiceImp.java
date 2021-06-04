package com.meli.caloriescalculator.service;

import com.meli.caloriescalculator.dto.DishDTO;
import com.meli.caloriescalculator.dto.IngredientDTO;
import com.meli.caloriescalculator.entity.Dish;
import com.meli.caloriescalculator.entity.Ingredient;
import com.meli.caloriescalculator.repository.IFoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CaloriesServiceImp implements ICaloriesService {

    @Autowired
    IFoodRepository foodRepository;

    @Override
    public DishDTO getDishData(Dish dish) {
        List<IngredientDTO> ingredients = getIngredientsCaloriesByWeight(dish.getIngredientList());
        double totalCalories = getTotalCalories(ingredients);
        IngredientDTO maxCalories = getMaxCaloriesIngredient(ingredients);
        return new DishDTO(dish.getName(), totalCalories, ingredients, maxCalories);
    }


    private List<IngredientDTO> getIngredientsCaloriesByWeight(List<Ingredient> ingredients) {
        return ingredients.stream().map(
                i -> new IngredientDTO(i.getName(), getIngredientTotalCalories(i))
        ).collect(Collectors.toList());
    }

    private double getIngredientTotalCalories(Ingredient i) {
        return i.getWeight() * getCaloriesByName(i.getName());
    }

    private double getCaloriesByName(String name) {
        return getIngredientByName(name).getCalories();
    }

    private IngredientDTO getIngredientByName(String name) {
        return foodRepository.findIngredientByName(name);
    }

    private double getTotalCalories(List<IngredientDTO> ingredients) {
        return ingredients.stream().mapToDouble(i -> i.getCalories()).sum();
    }

    private IngredientDTO getMaxCaloriesIngredient(List<IngredientDTO> ingredients) {
        return ingredients.stream().max(Comparator.comparing(IngredientDTO::getCalories)).get();
    }
}


