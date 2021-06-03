package com.ejercitacion.ejercitacion.calories.service;

import com.ejercitacion.ejercitacion.calories.dto.DishDTO;
import com.ejercitacion.ejercitacion.calories.dto.DishDataDTO;

import java.util.List;

public interface DishService {

    DishDataDTO calculateDishData(DishDTO dishDTO);
    List<DishDataDTO> calculateMultipleDishes(List<DishDTO> dishes);
}
