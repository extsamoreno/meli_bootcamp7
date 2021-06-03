package com.meli.calories.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.calories.service.dto.IngredientDTO;
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
    public IngredientDTO findIngredientByName(String name) {
        List<IngredientDTO> ingredientsDto = null;
        ingredientsDto = loadDatabase();
        IngredientDTO ingredient = null;
        if (ingredientsDto != null) {
            Optional<IngredientDTO> item = ingredientsDto.stream().filter(i -> i.getName().equals(name)).findFirst();
            if (item.isPresent()) ingredient = item.get();
        }
        return ingredient;
    }

    private List<IngredientDTO> loadDatabase() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:food.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<IngredientDTO>> typeRef = new TypeReference<>() {
        };
        List<IngredientDTO> ingredientsDto = null;
        try {
            ingredientsDto = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ingredientsDto;
    }
}