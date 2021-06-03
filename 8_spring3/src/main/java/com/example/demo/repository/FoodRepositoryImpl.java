package com.example.demo.repository;

import com.example.demo.dtos.DishDTO;
import com.example.demo.dtos.Ingredient;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Repository
public class FoodRepositoryImpl implements FoodRepository {

    @Override
    public Ingredient getIngredientByName(String name) {

        List<Ingredient> ingredients = loadDataBase();
        Ingredient ingredient = new Ingredient();

        if (ingredients != null) {
            Optional<Ingredient> item = ingredients.stream().filter(ingred -> ingred.getName().equals(name)).findFirst();
            if (item.isPresent()) {
                ingredient = item.get();
            }
        }
        return ingredient;
    }

    private List<Ingredient> loadDataBase() {

        File file = null;

        try {
            file = ResourceUtils.getFile("classpath:food.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Ingredient>> typeRef = new TypeReference<>() {
        };

        List<Ingredient> ingredientList = null;

        try {
            ingredientList = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ingredientList;
    }
}
