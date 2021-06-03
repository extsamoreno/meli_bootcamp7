package com.calorias.calorias.repositories;
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
public class IngredienteRepositoryImpl implements IngredienteRepository{

    @Override
    public Ingrediente findIngredienteByName(String name) {
        List<Ingrediente> ingredientesDTOS = null;
        ingredientesDTOS = loadDataBase();
        Ingrediente result = null;
        if(ingredientesDTOS != null){
            Optional<Ingrediente> item = ingredientesDTOS.stream()
                    .filter(ingrediente -> ingrediente.getName().equals(name))
                    .findFirst();
            if(item.isPresent()){
                result = item.get();
            }
        }

        return result;
    }

    public List<Ingrediente> loadDataBase(){
        File file = null;
        try{
            file = ResourceUtils.getFile("/Users/gcaiti/Downloads/calorias/src/main/java/com/calorias/calorias/repositories/food.json");
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Ingrediente>> typeRef = new TypeReference<>(){};
        List<Ingrediente> caloriesDTOS = null;
        try{
            caloriesDTOS = objectMapper.readValue(file,typeRef);
        }catch(IOException e){
            e.printStackTrace();
        }
        return caloriesDTOS;
    }


}
