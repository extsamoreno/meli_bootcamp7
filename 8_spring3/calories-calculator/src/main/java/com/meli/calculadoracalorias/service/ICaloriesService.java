package com.meli.calculadoracalorias.service;

import com.meli.calculadoracalorias.domain.Dish;
import com.meli.calculadoracalorias.service.dto.DishDTO;

public interface ICaloriesService {
    DishDTO getDishData(Dish dish);
}
