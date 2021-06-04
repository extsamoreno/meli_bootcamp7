package com.meli.caloriescalculator.repository;

import com.meli.caloriescalculator.dto.IngredientDTO;
import com.meli.caloriescalculator.entity.Ingredient;

public interface IFoodRepository {

    public IngredientDTO findIngredientByName(String name);

}
