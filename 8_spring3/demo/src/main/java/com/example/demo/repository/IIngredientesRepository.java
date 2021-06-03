package com.example.demo.repository;

import com.example.demo.entity.Ingrediente;

public interface IIngredientesRepository {

    Ingrediente getById(String nombre);
}
