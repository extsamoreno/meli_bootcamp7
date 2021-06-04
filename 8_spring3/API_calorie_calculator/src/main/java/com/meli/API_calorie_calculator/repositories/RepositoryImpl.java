package com.meli.API_calorie_calculator.repositories;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.API_calorie_calculator.service.dto.Ingredient;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Repository
public class RepositoryImpl implements Repository {
    @Override
    public Ingredient findIngredientByName(String name) {
        List<Ingredient> ingredientList = null;
        ingredientList = loadDataBase();
        Ingredient ingredientReturn = null;
        if (ingredientList != null) {
            Optional<Ingredient> item = ingredientList.stream()
                    .filter(ingredient -> ingredient.getName().equals(name))
                    .findFirst();
            if (item.isPresent()) {
                ingredientReturn = item.get();
            }
        }
        return ingredientReturn;
    }

    private List<Ingredient> loadDataBase() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:food.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Ingredient>> typeRef = new TypeReference<>() {};
        List<Ingredient> ingredientList = null;
        try {
            ingredientList = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ingredientList;
    }
}
