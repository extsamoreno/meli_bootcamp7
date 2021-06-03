package com.example.demo.repository;

import com.example.demo.dtos.Ingredient;
import org.springframework.stereotype.Repository;

import java.io.FileNotFoundException;

@Repository
public interface FoodRepository {

    Ingredient getIngredientByName(String name) throws FileNotFoundException;
}
