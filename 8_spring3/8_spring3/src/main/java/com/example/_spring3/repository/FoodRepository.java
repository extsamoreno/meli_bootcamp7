package com.example._spring3.repository;

import com.example._spring3.entity.Ingredient;
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
public class FoodRepository implements IFoodRepository {

    @Override
    public Ingredient getIngredientByName(String name) {
        List<Ingredient> caloriesList = loadDatabase();
        Ingredient result = null;
        if (caloriesList != null) {
            Optional<Ingredient> item = caloriesList.stream().filter(ingredient -> ingredient.getName().equals(name)).findFirst();
            if (item.isPresent()){
                result = item.get();
            }
        }
        return result;
    }
    private List<Ingredient> loadDatabase() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:food.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Ingredient>> typeRef = new TypeReference<>() {};
        List<Ingredient> ingredientes = null;
        try {
            ingredientes = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ingredientes;
    }
}

