package com.calorias.calorias.repositories;

public interface IngredienteRepository {
    Ingrediente findIngredienteByName(String name);
}
