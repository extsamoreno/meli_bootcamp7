package com.example.demo.repository;

import com.example.demo.domains.Ingredient;

public interface IFoodRepository {

    public Ingredient findIngredientByName(String name);
}
