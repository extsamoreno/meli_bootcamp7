package com.example.demo.calculadora.repository;

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
public class IngredientsRepository implements IIngredientsRepository {
    @Override
    public int getCalories(String name) {
        List<Ingredients> ingredientsDTO = null;
        ingredientsDTO = loadDatabase();
        int result = 0;
        if (ingredientsDTO!=null){
            Optional<Ingredients> item = ingredientsDTO.stream().filter(ingredients -> ingredients.getName().equals(name)).findFirst();
            if (item.isPresent()){
                result = item.get().getCalories();
            }
        }
        return result;
    }
    private List<Ingredients> loadDatabase() {
        File file = null;
        try {
            file = ResourceUtils.getFile("src/main/resources/static/food.json");
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Ingredients>> typeReference = new TypeReference<>() {};
        List<Ingredients> ingredients = null;
        try {
            ingredients =  objectMapper.readValue(file,typeReference);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return ingredients;

    }
}
