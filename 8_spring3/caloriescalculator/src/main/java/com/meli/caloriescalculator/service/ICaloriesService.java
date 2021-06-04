package com.meli.caloriescalculator.service;

import com.meli.caloriescalculator.dto.DishDTO;
import com.meli.caloriescalculator.entity.Dish;

public interface ICaloriesService {
    public DishDTO getDishData(Dish dish);

}
