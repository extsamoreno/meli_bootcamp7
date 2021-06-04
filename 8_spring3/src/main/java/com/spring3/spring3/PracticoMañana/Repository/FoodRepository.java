package com.spring3.spring3.PracticoMañana.Repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring3.spring3.PracticoMañana.Classes.Ingredient;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@Repository
public class FoodRepository implements IFoodRepository {

    @Override
    public Ingredient findIngredientsByName(String name) {
        for (Ingredient i : this.loadDataBase()) {
            if (i.getName().contains(name)) return i;
        }
        return null;
    }

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
}
