package com.example.demo.calculadora.repository;

import org.springframework.stereotype.Repository;

@Repository
public interface IIngredientsRepository {
    public int getCalories(String name);
}
