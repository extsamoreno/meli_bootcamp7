package com.spring3.calculadorapropia.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring3.calculadorapropia.service.dtos.FoodRequestDTO;
import com.spring3.calculadorapropia.service.dtos.FoodResponseDTO;
import com.spring3.calculadorapropia.service.dtos.IngredientResponseDTO;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.*;
import java.util.List;
import java.util.Optional;

@Repository
public class CalculadoraRepositoryImpl implements CalculadoraRepository {

    @Override
    public IngredientResponseDTO findIngredientByName (String ingredient) {
        List<IngredientResponseDTO> ingredientResponseDTOS = null;
        ingredientResponseDTOS = loadDataBase();
        IngredientResponseDTO result = null;
        if (ingredientResponseDTOS != null) {
            Optional<IngredientResponseDTO> item = ingredientResponseDTOS.stream()
                    .filter(ingredientResponseDTO -> ingredientResponseDTO.getName().equals(ingredient))
                    .findFirst();
            if(item.isPresent())
                result = item.get();
        }
        return result;
    }

    private List<IngredientResponseDTO> loadDataBase() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:food.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<IngredientResponseDTO>> typeRef = new TypeReference<>() {};
        List<IngredientResponseDTO> ingredientResponseDTOS = null;
        try {
            ingredientResponseDTOS = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ingredientResponseDTOS;
    }
}
