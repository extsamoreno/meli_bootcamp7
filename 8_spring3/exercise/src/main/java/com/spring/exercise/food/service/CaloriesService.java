package com.spring.exercise.food.service;

import com.spring.exercise.food.model.Dish;
import com.spring.exercise.food.model.Ingredient;
import com.spring.exercise.food.model.dto.DishDTO;
import com.spring.exercise.food.model.dto.IngredientDTO;
import com.spring.exercise.food.repository.IFoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CaloriesService implements ICaloriesService {

    @Autowired
    IFoodRepository foodRepository;

    @Override
    public DishDTO getDishData(Dish dish) {
        List<IngredientDTO> ingredients = getIngredientsCaloriesByWeight(dish.getIngredients());
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
