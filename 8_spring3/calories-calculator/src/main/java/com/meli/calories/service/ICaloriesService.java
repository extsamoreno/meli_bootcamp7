package com.meli.calories.service;

import com.meli.calories.domain.Dish;
import com.meli.calories.service.dto.DishDTO;

public interface ICaloriesService {
    public DishDTO getDishData(Dish dish);
}