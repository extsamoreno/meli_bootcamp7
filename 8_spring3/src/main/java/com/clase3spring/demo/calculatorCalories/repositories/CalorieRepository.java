package com.clase3spring.demo.calculatorCalories.repositories;

import com.clase3spring.demo.calculatorCalories.models.CalorieDTO;
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
public class CalorieRepository implements ICalorieRepository{

    @Override
    public CalorieDTO findCaloriesByFood(String food) {
        List<CalorieDTO> caloriesDTOS = loadDatase();
        return caloriesDTOS.stream().filter(caloryDTO -> caloryDTO.getName().equals(food)).findFirst().get();
    }

    private List<CalorieDTO> loadDatase() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:food.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<CalorieDTO>> typeRef = new TypeReference<>() {};
        List<CalorieDTO> caloriesDTOS = null;

        try {
            caloriesDTOS = objectMapper.readValue(file, typeRef);
        } catch(IOException e) {
            e.printStackTrace();
        }
        return caloriesDTOS;
    }
}