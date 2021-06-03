package com.spring3.clase3spring.Services;

import com.spring3.clase3spring.Entities.*;
import com.spring3.clase3spring.Repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

@Service
public class CaloriesCalculatorService implements iCaloriesCalculatorService{

    @Autowired
    iCaloriesRepository iCaloriesRepository;

    @Override
    public TotalCaloriesDTO calculateTotalCalories(Meal meal) {
        Integer calories = 0;
        for (Ingredient ingredient: meal.getIngredients()) {
            calories += (iCaloriesRepository.findCaloriesByFood(ingredient.getName()).getCalories() * ingredient.getWeight());
        }

        return new TotalCaloriesDTO(meal, calories);
    }

    @Override
    public IngredientCalorieDTO calculateCaloriesPerIngredient(Meal meal) {
        ArrayList<CaloriesDTO> listIngredientsCalories = new ArrayList<>();

        for (Ingredient ingredient: meal.getIngredients()) {
            String name = iCaloriesRepository.findCaloriesByFood(ingredient.getName()).getName();
            Integer calories = iCaloriesRepository.findCaloriesByFood(ingredient.getName()).getCalories();
            listIngredientsCalories.add(new CaloriesDTO(name, calories));
        }

        return new IngredientCalorieDTO(meal, listIngredientsCalories);
    }

    @Override
    public CaloriesDTO mostCaloricIngredient(Meal meal) {
        Integer calorie = 0;
        CaloriesDTO calories = new CaloriesDTO();

        for (Ingredient ingredient: meal.getIngredients()) {
            if (iCaloriesRepository.findCaloriesByFood(ingredient.getName()).getCalories() > calorie) {
                calorie = iCaloriesRepository.findCaloriesByFood(ingredient.getName()).getCalories();
                calories.setCalories(calorie);
                calories.setName(ingredient.getName());
            }
        }

        return calories;
    }

    @Override
    public ArrayList<MealDTO> processMeal(ArrayList<Meal> meals) {
        ArrayList<MealDTO> mealsDTO = new ArrayList<>();

        for (Meal meal: meals) {
            MealDTO mealDTO = new MealDTO();
            mealDTO.setTotalCalories(calculateTotalCalories(meal).getResult());
            mealDTO.setListCaloriesIngredients(calculateCaloriesPerIngredient(meal).getListCaloriesIngredients());
            mealDTO.setMeal(meal);
            mealDTO.setCaloriesDTO(mostCaloricIngredient(meal));
            mealsDTO.add(mealDTO);
        }

        return mealsDTO;
    }
}
