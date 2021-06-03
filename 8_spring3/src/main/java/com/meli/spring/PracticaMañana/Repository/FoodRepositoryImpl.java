package com.meli.spring.PracticaMañana.Repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.spring.PracticaMañana.Classes.Ingrediente;
import com.meli.spring.PracticaMañana.Dto.IngredienteDto;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Repository
public class FoodRepositoryImpl implements FoodRepository {

    @Override
    public IngredienteDto findCalorias(Ingrediente ingrediente) {
        List<IngredienteDto> ingredienteDtoList = loadDataBase();
        IngredienteDto result = null;
        if(ingredienteDtoList != null){
            Optional<IngredienteDto> item = ingredienteDtoList.stream()
                                                .filter(ingredienteDto -> ingredienteDto.getName().equals(ingrediente.getNombre()))
                                                .findFirst();
            if(item.isPresent()){
                result = item.get();
            }
        }
    return result;
    }

    private List<IngredienteDto> loadDataBase(){
        File file = null;
        try{
            file = ResourceUtils.getFile("classpath:food.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper om = new ObjectMapper();
        TypeReference<List<IngredienteDto>> typeDef = new TypeReference<>(){};
        List<IngredienteDto> ingredienteDtoList = null;
        try{
            ingredienteDtoList = om.readValue(file,typeDef);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return ingredienteDtoList;
    }
}
