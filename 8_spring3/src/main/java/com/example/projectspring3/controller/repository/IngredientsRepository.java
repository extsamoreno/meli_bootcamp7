package com.example.projectspring3.controller.repository;

import com.example.projectspring3.controller.service.CaloriesDTO;
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


    private List<CaloriesDTO> loadDataBase() {
        File file = null;
        try{
            file = ResourceUtils.getFile("classpath:food.json");
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<CaloriesDTO>> typeRef = new TypeReference<>() {};
        List<CaloriesDTO> caloriesDTOS = null;

        try {
            caloriesDTOS = objectMapper.readValue(file,typeRef);
        } catch (IOException e){
            e.printStackTrace();
        }
        return caloriesDTOS;

    }

    @Override
    public CaloriesDTO findCaloriesByName(String nombre) {
        List<CaloriesDTO> caloriesDTOS = null;
        caloriesDTOS = loadDataBase();
        CaloriesDTO resultado = null;
        for(CaloriesDTO caloriesDTO:caloriesDTOS){
            if(caloriesDTO.getName().equals(nombre)){
                resultado = caloriesDTO;
                break;
            }
        }

        return resultado;
    }
}
