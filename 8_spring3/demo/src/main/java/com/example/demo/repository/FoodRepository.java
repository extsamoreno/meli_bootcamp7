package com.example.demo.repository;

import com.example.demo.domains.Ingredient;
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
public class FoodRepository implements IFoodRepository{

    @Override
    public Ingredient findIngredientByName(String name){

        List<Ingredient> ingredients = loadDataBase();
        Ingredient result = new Ingredient();

        if (ingredients != null){
            Optional<Ingredient> item = ingredients.stream()
                    .filter(ingredient -> ingredient.getName().equals(name))
                    .findFirst();
            if (item.isPresent())
                result = item.get();
        }

        return result;
    }

    private List<Ingredient> loadDataBase() {
        File file = null;
        try{
            file = ResourceUtils.getFile("/Users/mstefanutti/workplace/meli_bootcamp7/8_spring3/demo/src/main/resources/food.json");
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }

        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Ingredient>> typeRef = new TypeReference<>() {};

        List<Ingredient> ingredients = null;

        try {
            ingredients = objectMapper.readValue(file, typeRef);
        } catch (IOException e){
            e.printStackTrace();
        }
        return ingredients;
    }
}
