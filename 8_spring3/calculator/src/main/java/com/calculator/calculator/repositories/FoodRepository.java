package com.calculator.calculator.repositories;

import com.calculator.calculator.dtos.FoodDTO;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOError;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
public class FoodRepository implements IFoodRepository {

    @Override
    public FoodDTO foodByName(String name) {
        FoodDTO foodDTO = null;

        List<FoodDTO> foodDTOList = loadDatabase();

        if (!Objects.isNull(foodDTOList)) {
            Optional<FoodDTO> item = foodDTOList.stream()
                    .filter(foodDTO1 -> foodDTO1.getName().equals(name))
                    .findFirst();

            foodDTO = item.isPresent() ? item.get() : null;
        }
        return foodDTO;
    }

    private List<FoodDTO> loadDatabase() {
        File file = null;

        try {
            file = ResourceUtils.getFile("classpath:food.json");
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            file = null;
        }
        ObjectMapper objectMapper = new ObjectMapper();

        TypeReference<List<FoodDTO>> typeReference = new TypeReference<>() {};
        List<FoodDTO> foodDTOS = null;
        try {
            foodDTOS = objectMapper.readValue(file, typeReference);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return foodDTOS;
    }
}
