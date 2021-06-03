package com.example.demo.service;

import com.example.demo.repository.Dish;
import com.example.demo.repository.Ingredients;
import com.example.demo.service.DTO.IngredientsDTO;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public interface IFoodService {

    public void saveDish(Dish dish);

    public double getCaloriesFromDish(Dish dish);

    public Dish getDishFromName(String name);

    public HashMap<Ingredients, Double> getEachCalories(Dish dish);

    public Ingredients getMostCalories(Dish dish);
}
