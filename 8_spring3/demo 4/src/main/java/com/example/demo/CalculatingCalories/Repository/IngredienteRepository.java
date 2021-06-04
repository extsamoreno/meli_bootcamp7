package com.example.demo.CalculatingCalories.Repository;

public interface IngredienteRepository {
    Ingrediente findIngredienteByName(String name);
}