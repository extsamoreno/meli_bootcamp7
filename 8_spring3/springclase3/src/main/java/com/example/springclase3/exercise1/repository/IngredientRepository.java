package com.example.springclase3.exercise1.repository;
import com.example.springclase3.exercise1.service.dto.IngredientDTO;
import com.example.springclase3.exercise1.service.dto.InputIngredient;
import com.example.springclase3.exercise1.service.mapper.PlateMapper;
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
public class IngredientRepository implements IIngredientRepository{

//    private final List<IngredientDTO> ingredientDTOs = loadDataBase();

    @Override
    public IngredientDTO findCalories(Ingredient ingredient) {
        List<IngredientDTO> ingredientDTOs = loadDataBase();
        IngredientDTO result = null;
        if(ingredientDTOs != null){
            Optional<IngredientDTO> item = ingredientDTOs.stream()
                    .filter(ingredientDTO -> ingredientDTO.getName().equals(ingredient.getName()))
                    .findFirst();
            if(item.isPresent()){
                result = item.get();
            }
        }
        return result;
    }

    @Override
    public Integer findIngredientCalories(InputIngredient inputIngredient) {
        List<IngredientDTO> ingredientDTOs = loadDataBase();
        Integer result = null;
        if (ingredientDTOs != null) {
            for (IngredientDTO ingrDTO :
                    ingredientDTOs) {
                if (inputIngredient.getName().equals(ingrDTO.getName())) {
                    result = ingrDTO.getCalories();
                    break;
                }
            }
        }
        return result;
    }

    private List<IngredientDTO> loadDataBase () {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:food.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper om = new ObjectMapper();
        TypeReference<List<IngredientDTO>> typeDef = new TypeReference<>() {
        };
        List<IngredientDTO> ingredientDTOList = null;
        try {
            ingredientDTOList = om.readValue(file, typeDef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ingredientDTOList;

    }
}