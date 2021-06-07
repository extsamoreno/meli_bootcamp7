package com.example.demo.repository;

import com.example.demo.model.Ingredient;
import org.springframework.stereotype.Repository;

import java.io.FileNotFoundException;

@Repository
public interface IFoodRepository {

    Ingredient getIngredientByName(String name) throws FileNotFoundException;
}
