package com.example.food.repository;

import com.example.food.services.dto.IngredientsDTO;

public interface IFoodRepository {
    IngredientsDTO searchByName(String name);
}
