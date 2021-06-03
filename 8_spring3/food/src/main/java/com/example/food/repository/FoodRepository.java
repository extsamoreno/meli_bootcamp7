package com.example.food.repository;

import com.example.food.services.dto.IngredientsDTO;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
public class FoodRepository implements IFoodRepository {

    @Override
    public IngredientsDTO searchByName(String name) {
        IngredientsDTO ingredientsDTO = null;
        List<IngredientsDTO> ingredientsLst = LoadDataBase();

        if (!Objects.isNull(ingredientsLst)){
            Optional<IngredientsDTO> result = ingredientsLst.stream().filter(ingredientDTO1 -> ingredientDTO1.getName().equals(name)).findFirst();
            ingredientsDTO = result.isPresent() ? result.get() : null;
        }

        return ingredientsDTO;
    }

    private List<IngredientsDTO> LoadDataBase(){
        File file = null;

        try {
            file = ResourceUtils.getFile("classpath:food.json");
        } catch (FileNotFoundException ex){
            ex.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();

        TypeReference<List<IngredientsDTO>> typeReference = new TypeReference<>() {};
        List<IngredientsDTO> ingredients = null;

        try{
            ingredients = objectMapper.readValue(file,typeReference);
        } catch (IOException x){
            x.printStackTrace();
        }
        return ingredients;
    }
}
