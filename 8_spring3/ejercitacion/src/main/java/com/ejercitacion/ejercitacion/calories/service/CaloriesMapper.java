package com.ejercitacion.ejercitacion.calories.service;

import com.ejercitacion.ejercitacion.calories.entity.Calories;
import com.ejercitacion.ejercitacion.calories.dto.CaloriesDTO;

public class CaloriesMapper {

    public static CaloriesDTO toDTO(Calories calories) {
        return new CaloriesDTO(calories.getName(), calories.getCalories());
    }

    public static Calories toEntity(CaloriesDTO caloriesDTO) {
        return new Calories(caloriesDTO.getName(), caloriesDTO.getCalories());
    }
}
