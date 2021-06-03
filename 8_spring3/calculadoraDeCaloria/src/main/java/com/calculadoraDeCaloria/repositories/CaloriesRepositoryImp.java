package com.calculadoraDeCaloria.repositories;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.models.CaloriesDTO;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Repository
public class CaloriesRepositoryImp implements iCaloriesRepository{

    @Override
    public CaloriesDTO findCaloriesByFood(String food) {
        List<CaloriesDTO> caloriesDTOS = loadDatase();
        return caloriesDTOS.stream().filter(caloryDTO -> caloryDTO.getName().equals(food)).findFirst().get();
    }

    private List<CaloriesDTO> loadDatase() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:food.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<CaloriesDTO>> typeRef = new TypeReference<>() {};
        List<CaloriesDTO> caloriesDTOS = null;

        try {
            caloriesDTOS = objectMapper.readValue(file, typeRef);
        } catch(IOException e) {
            e.printStackTrace();
        }
        return caloriesDTOS;
    }
}
