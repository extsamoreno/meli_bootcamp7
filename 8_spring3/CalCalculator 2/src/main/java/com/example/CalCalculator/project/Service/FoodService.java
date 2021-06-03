package com.example.CalCalculator.project.Service;

import com.example.CalCalculator.project.Entities.Dish;
import com.example.CalCalculator.project.Entities.Food;
import com.example.CalCalculator.project.Repository.IFoodRepository;
import com.example.CalCalculator.project.Service.dto.DishDTO;
import com.example.CalCalculator.project.Service.dto.FoodDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FoodService implements IFoodService {

    @Autowired
    IFoodRepository iFoodRepository;

    @Override
    public DishDTO getDishData(Dish dish) {
        List<FoodDTO> ingredients = getIngredientsCaloriesByWeight(dish.getIngredients());
        double totalCalories = getTotalCalories(ingredients);
        FoodDTO mostCaloric = this.getMaxCaloriesIngredient(ingredients);
        return new DishDTO(dish.getName(), ingredients, totalCalories,mostCaloric);
    }

    private List<FoodDTO> getIngredientsCaloriesByWeight(List<Food> ingredients) {
        return ingredients.stream().map(
                i -> new FoodDTO(i.getName(), getIngredientTotalCalories(i))
        ).collect(Collectors.toList());
    }

    private double getIngredientTotalCalories(Food i) {
        return i.getGrams() * getFoodByName(i.getName()).getCalories();
    }

    private FoodDTO getFoodByName(String name) {
        return iFoodRepository.getByName(name);
    }

    private double getTotalCalories(List<FoodDTO> ingredients) {
        return ingredients.stream().mapToDouble(FoodDTO::getCalories).sum();
    }

    private FoodDTO getMaxCaloriesIngredient(List<FoodDTO> ingredients) {
        FoodDTO ingr = null;
        Optional<FoodDTO> ingredient = ingredients.stream().max(Comparator.comparing(FoodDTO::getCalories));
        if(ingredient.isPresent()) ingr = ingredient.get();
        return ingr;
    }
}
