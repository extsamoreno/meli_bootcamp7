package com.meli.caloria.repository;


import java.util.List;

public interface IngredientRepository {
    public List<Ingredient> getIngredientList();
    public Ingredient getIngredientByName(String name);
}
