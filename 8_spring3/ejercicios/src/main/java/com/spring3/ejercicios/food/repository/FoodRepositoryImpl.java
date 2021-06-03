package com.spring3.ejercicios.food.repository;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring3.ejercicios.food.Ingredient;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@Repository
public class FoodRepositoryImpl implements IFoodRepository {

    @Override
    public Ingredient findIngredientByName(String name) {
        List<Ingredient> ingredients;
        ingredients = loadDateBase();
        Ingredient ingredientSelected = null;
        for (Ingredient ing : ingredients) {
            if (ing.getName().equals(name)) {
                ingredientSelected = ing;
            }
        }
        return ingredientSelected;
    }

    private List<Ingredient> loadDateBase() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:food.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper om = new ObjectMapper();
        TypeReference<List<Ingredient>> typeDef = new TypeReference<>() {
        };
        List<Ingredient> ingredientList = null;
        try {
            ingredientList = om.readValue(file, typeDef);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return ingredientList;
    }
}
