package com.example.demo.repository;

import com.example.demo.models.Ingredient;

public interface IFoodRepository {

    public Ingredient findIngredientByName(String name);
}
