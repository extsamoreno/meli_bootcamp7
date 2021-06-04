package com.spring3.spring3.PracticoMañana.Repository;

import com.spring3.spring3.PracticoMañana.Classes.Ingredient;

public interface IFoodRepository {
    public Ingredient findIngredientsByName(String name);
}
