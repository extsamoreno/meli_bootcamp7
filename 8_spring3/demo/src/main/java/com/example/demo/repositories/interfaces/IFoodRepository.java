package com.example.demo.repositories.interfaces;

import com.example.demo.classes.Ingredient;

public interface IFoodRepository {

    Ingredient findIngredientByName(String name);
}