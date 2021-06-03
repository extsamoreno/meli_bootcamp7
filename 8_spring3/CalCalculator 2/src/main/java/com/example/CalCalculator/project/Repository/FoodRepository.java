package com.example.CalCalculator.project.Repository;

import com.example.CalCalculator.project.Service.dto.FoodDTO;
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
public class FoodRepository implements IFoodRepository {


    @Override
    public FoodDTO getByName(String name){

        List<FoodDTO> ingredients = this.loadDataBase();
        FoodDTO foodDTO = null;

        Optional<FoodDTO> response = ingredients.stream().filter(ingredient -> ingredient.getName().equals(name)).findFirst();

        return response.isPresent() ? response.get() : null;


    }


    private List<FoodDTO> loadDataBase(){

        File file = null;
        try{
            file = ResourceUtils.getFile("classpath:food.json");
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<FoodDTO>> typeRef = new TypeReference<>() {};
        List<FoodDTO> foodDTOS = null;
        try{
            foodDTOS = objectMapper.readValue(file, typeRef);
        }
        catch(IOException e){
            e.printStackTrace();
        }

        return foodDTOS;
    }
}
