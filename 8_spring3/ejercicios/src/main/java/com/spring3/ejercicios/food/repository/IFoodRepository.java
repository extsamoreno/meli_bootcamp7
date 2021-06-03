package com.spring3.ejercicios.food.repository;

import com.spring3.ejercicios.food.Ingredient;

public interface IFoodRepository {

    public Ingredient findIngredientByName(String name);
}
