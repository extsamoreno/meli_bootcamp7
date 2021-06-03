package com.meli.caloria.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.caloria.service.dto.IngredientDTO;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@Repository
public class IngredientRepositoryImple implements IngredientRepository{

    @Override
    public List<Ingredient> getIngredientList() {
        File file=null;
        try{
            file= ResourceUtils.getFile("/Users/mirivera/Documents/meli_bootcamp7/8_spring3/src/main/resources/food.json");

        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
        ObjectMapper objectMapper= new ObjectMapper();
        TypeReference<List<Ingredient>> typeReference= new TypeReference<>() {};
        List<Ingredient> ingredient=null;
        try{
            ingredient = objectMapper.readValue(file, typeReference);
        } catch (IOException e){
            e.printStackTrace();
        }
        return ingredient;
    }

    @Override
    public Ingredient getIngredientByName(String name) {
        List<Ingredient> list= getIngredientList();
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getName().equals(name)) return list.get(i);
        }
        return null;
    }
}
