package com.example.spring3.repositories;

import com.example.spring3.classes.Ingredient;
import com.example.spring3.repositories.interfaces.IFoodRepository;
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
    public Ingredient findIngredientByName(String name) {
        List<Ingredient> ingredientList = null;
        ingredientList = loadDateBase();
        Ingredient result = null;
        if(ingredientList != null) {
            Optional<Ingredient> item = ingredientList.stream()
                    .filter(ingredient -> ingredient.getName().equals(name))
                    .findFirst();
            if(item.isPresent()) {
                result = item.get();
            }
        }
        return result;
    }

    private List<Ingredient> loadDateBase() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:food.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Ingredient>> typeRef = new TypeReference<>(){};
        List<Ingredient>  ingredientList = null;
        try {
            ingredientList = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ingredientList;
    }
}
