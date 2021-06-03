package com.meli.CalculadoraDeCalorias.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.CalculadoraDeCalorias.service.DTO.IngredientDTO;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
public class IngredientRepository implements IIngredientRepository {

    @Override
    public IngredientDTO searchByName(String name) {
        IngredientDTO ingredientDTO = null;
        List<IngredientDTO> ingredientList = LoadDataBase();
        if (!Objects.isNull(ingredientList)) {
            Optional<IngredientDTO> result = ingredientList.stream().filter(ingredientDTO1 -> ingredientDTO1.getName().equals(name)).findFirst();
            ingredientDTO = result.isPresent() ? result.get() : null;
        }
        return ingredientDTO;
    }

    private List<IngredientDTO> LoadDataBase() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:food.json");
        } catch (FileNotFoundException x) {
            x.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<IngredientDTO>> typeReference = new TypeReference<List<IngredientDTO>>() {
        };
        List<IngredientDTO> ingredientDTOS = null;
        try {
            ingredientDTOS = objectMapper.readValue(file, typeReference);
        } catch (IOException x) {
            x.printStackTrace();
        }
        return ingredientDTOS;
    }
}
