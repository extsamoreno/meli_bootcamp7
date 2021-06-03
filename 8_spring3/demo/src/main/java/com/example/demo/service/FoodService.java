package com.example.demo.service;

import com.example.demo.repository.Dish;
import com.example.demo.repository.IIngredientsRepository;
import com.example.demo.repository.Ingredients;
import com.example.demo.service.DTO.IngredientsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class FoodService implements IFoodService {

    ArrayList<Dish> dishes = new ArrayList<>();

    @Autowired
    IIngredientsRepository ingredientsRepository;

    @Override
    public void saveDish(Dish dish) {
        dishes.add(dish);
    }

    @Override
    public double getCaloriesFromDish(Dish dish) {
        double calories = 0.0;
        for (Ingredients i: dish.getIngredients()) {
            calories += ingredientsRepository.findCalorias(i).getCalories();
        }

        return calories;
    }

    @Override
    public Dish getDishFromName(String name){

        for (Dish d: dishes) {
            if(d.getName().equals(name)){
                return d;
            }
        }
        return null;
    }

    @Override
    public HashMap<Ingredients, Double> getEachCalories(Dish dish) {
        HashMap<Ingredients, Double> map = new HashMap<>();

        for (Ingredients i : dish.getIngredients()) {
            map.put(i, ingredientsRepository.findCalorias(i).getCalories());
        }

        return map;
    }

    @Override
    public Ingredients getMostCalories(Dish dish) {
        ArrayList<Double> arr = new ArrayList<>();
        HashMap<Ingredients, Double> map = new HashMap<>();

        for (Ingredients i : dish.getIngredients()) {
           arr.add(ingredientsRepository.findCalorias(i).getCalories());
           map.put(i, ingredientsRepository.findCalorias(i).getCalories());
           if(ingredientsRepository.findCalorias(i).getCalories() == arr.stream().max(Double :: compare).get()){
               return i;
           }
        }

        return null;

    }


}
