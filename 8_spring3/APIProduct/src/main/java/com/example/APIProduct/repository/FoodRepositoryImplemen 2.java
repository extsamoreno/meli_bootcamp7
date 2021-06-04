package com.example.APIProduct.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;
import com.fasterxml.jackson.core.type.TypeReference;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Repository
public class FoodRepositoryImplemen implements IFoodRepository {


    private List<Ingredient> loadDataBase(){
        File file = null;
        try{
            file = ResourceUtils.getFile("classpath:food.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper om = new ObjectMapper();
        TypeReference<List<Ingredient>> typeDef = new TypeReference<>(){};
        List<Ingredient> ingredienteDtoList = null;
        try{
            ingredienteDtoList = om.readValue(file,typeDef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ingredienteDtoList;
    }


    @Override
    public Ingredient getByName(String name) {
            List<Ingredient> ingredientList = loadDataBase();

            Ingredient result = null;
            if(ingredientList != null){
                Optional<Ingredient> item = ingredientList.stream()
                        .filter(ingredient -> ingredient.getName().equals(name))
                        .findFirst();
                if(item.isPresent()){
                    result = item.get();
                }
            }
            return result;
        }
}
