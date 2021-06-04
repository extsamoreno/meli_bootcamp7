package com.example._spring3.repository;


import com.example._spring3.entity.Ingredient;

import java.util.List;

public interface IFoodRepository {
    Ingredient getIngredientByName(String name);
}
