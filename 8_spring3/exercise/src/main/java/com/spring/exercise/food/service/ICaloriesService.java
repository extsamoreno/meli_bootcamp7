package com.spring.exercise.food.service;

import com.spring.exercise.food.model.Dish;
import com.spring.exercise.food.model.dto.DishDTO;

public interface ICaloriesService {
    public DishDTO getDishData(Dish dish);
}
