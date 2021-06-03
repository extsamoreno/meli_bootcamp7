package com.example.spring3.repositories.interfaces;

import com.example.spring3.classes.Ingredient;

public interface IFoodRepository {

    Ingredient findIngredientByName(String name);
}
