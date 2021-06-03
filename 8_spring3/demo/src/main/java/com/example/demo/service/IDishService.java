package com.example.demo.service;

import com.example.demo.dto.DishDTO;
import com.example.demo.dto.FoodCaloriesDTO;
import org.springframework.stereotype.Service;

//@Service
public interface IDishService {
    FoodCaloriesDTO getCalories(DishDTO dish);
}
