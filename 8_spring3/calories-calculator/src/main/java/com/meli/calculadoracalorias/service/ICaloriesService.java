package com.meli.calculadoracalorias.service;

import com.meli.calculadoracalorias.domain.Dish;
import com.meli.calculadoracalorias.service.dto.DishDTO;

import java.util.List;

public interface ICaloriesService {
    DishDTO getDishData(Dish dish);

    List<DishDTO> getDishesData(List<Dish> dishes);
}
