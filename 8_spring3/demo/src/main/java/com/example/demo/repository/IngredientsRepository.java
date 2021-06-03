package com.example.demo.repository;

import com.example.demo.service.DTO.IngredientsDTO;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.tomcat.util.json.JSONParser;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Repository
public class IngredientsRepository implements IIngredientsRepository{

    private List<IngredientsDTO> dataBase;

    public IngredientsRepository() {
        dataBase = loadDataBase();
    }

    @Override
    public IngredientsDTO findCalorias(Ingredients ingredient) {
        List<IngredientsDTO> ingredienteDtoList = loadDataBase();
        IngredientsDTO result = null;
        if(ingredienteDtoList != null){
            Optional<IngredientsDTO> item = ingredienteDtoList.stream()
                    .filter(ingredienteDto -> ingredienteDto.getName().equals(ingredient.getName()))
                    .findFirst();
            if(item.isPresent()){
                result = item.get();
            }
        }
        return result;
    }

    private List<IngredientsDTO> loadDataBase(){
        File file = null;
        try{
            file = ResourceUtils.getFile("classpath:food.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper om = new ObjectMapper();
        TypeReference<List<IngredientsDTO>> typeDef = new TypeReference<>(){};
        List<IngredientsDTO> ingredienteDtoList = null;
        try{
            ingredienteDtoList = om.readValue(file,typeDef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ingredienteDtoList;
    }
}
