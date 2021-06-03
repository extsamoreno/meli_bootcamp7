package com.meli.caloria.service;

import com.meli.caloria.repository.Dish;
import com.meli.caloria.repository.Ingredient;
import com.meli.caloria.service.dto.DishDTO;

import java.util.List;

public interface IDishService {

    public DishDTO calcularCaloriasTotales(Dish dish);
    public List<Ingredient> imprimirCaloriasPorIngrediente(Dish dish);
    public Ingredient calcularIngredienteMasCalorico(Dish dish);
}
