package com.ejercitacion.ejercitacion.calories.repository;

import com.ejercitacion.ejercitacion.calories.entity.Calories;
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
public class DishRepositoryImpl implements DishRepository {

    public Calories getById(String name) {
       List<Calories> caloriesList = loadDatabase();
       Calories result = null;
       if (caloriesList != null) {
           Optional<Calories> item = caloriesList.stream().filter(calories -> calories.getName().equals(name)).findFirst();
           if (item.isPresent()){
               result = item.get();
           }
       }
       return result;
    }

    private List<Calories> loadDatabase() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:food.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Calories>> typeRef = new TypeReference<>() {};
        List<Calories> calories = null;

        try {
            calories = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return calories;
    }
}
