package com.meli.calculadoracalorias.service;

import com.meli.calculadoracalorias.domain.Dish;
import com.meli.calculadoracalorias.domain.Ingredient;
import com.meli.calculadoracalorias.repository.IFoodRepository;
import com.meli.calculadoracalorias.service.dto.DishDTO;
import com.meli.calculadoracalorias.service.dto.IngredientDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    @Override
    public List<DishDTO> getDishesData(List<Dish> dishes) {
        return dishes.stream()
                .map(elem -> getDishData(elem))
                .collect(Collectors.toList());
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
