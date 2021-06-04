package com.clase3spring.demo.calculatorCalories.services;

import com.clase3spring.demo.calculatorCalories.repositories.ICalorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.clase3spring.demo.calculatorCalories.models.*;

import java.util.ArrayList;

@Service
public class CalorieService  implements ICalorieService{

    @Autowired
    ICalorieRepository calorieRepository;

    @Override
    public TotalCaloriesDTO calculateTotalCalories(Meal meal) {
        Integer calories = 0;
        for (Ingredient ingredient: meal.getIngredients()) {
            calories += (calorieRepository.findCaloriesByFood(ingredient.getName()).getCalories() * ingredient.getWeight());
        }

        return new TotalCaloriesDTO(meal, calories);
    }

    @Override
    public IngredientCalorieDTO calculateCaloriesPerIngredient(Meal meal) {
        ArrayList<CalorieDTO> listIngredientsCalories = new ArrayList<>();

        for (Ingredient ingredient: meal.getIngredients()) {
            String name = calorieRepository.findCaloriesByFood(ingredient.getName()).getName();
            Integer calories = calorieRepository.findCaloriesByFood(ingredient.getName()).getCalories();
            listIngredientsCalories.add(new CalorieDTO(name, calories));
        }

        return new IngredientCalorieDTO(meal, listIngredientsCalories);
    }

    @Override
    public CalorieDTO mostCaloricIngredient(Meal meal) {
        Integer calorie = 0;
        CalorieDTO calories = new CalorieDTO();

        for (Ingredient ingredient: meal.getIngredients()) {
            if (calorieRepository.findCaloriesByFood(ingredient.getName()).getCalories() > calorie) {
                calorie = calorieRepository.findCaloriesByFood(ingredient.getName()).getCalories();
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
