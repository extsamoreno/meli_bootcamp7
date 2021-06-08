package com.example.demo.calculadora.service;

import com.example.demo.calculadora.Dish;
import com.example.demo.calculadora.repository.Ingredients;
import com.example.demo.calculadora.service.dto.DishDTO;
import com.example.demo.calculadora.service.dto.IngredientsDTO;
import org.springframework.stereotype.Service;

@Service
public interface IDishService {
    DishDTO totalCalories(Dish dish);
    DishDTO ingredientsCalories(Dish dish);
    IngredientsDTO moreCalories(Dish dish);
}
