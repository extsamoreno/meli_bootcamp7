package com.clase3spring.demo.calculatorCalories.repositories;

import com.clase3spring.demo.calculatorCalories.models.CalorieDTO;

public interface ICalorieRepository {
    CalorieDTO findCaloriesByFood(String food);
}
