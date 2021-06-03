package com.ejercitacion.ejercitacion.calories.repository;

import com.ejercitacion.ejercitacion.calories.entity.Calories;

public interface DishRepository {

    Calories getById(String name);

}
