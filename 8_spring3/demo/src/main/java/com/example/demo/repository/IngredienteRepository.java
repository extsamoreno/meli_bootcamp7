package com.example.demo.repository;

import com.example.demo.entity.Ingrediente;
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
public class IngredienteRepository implements IIngredientesRepository{

    @Override
    public Ingrediente getById(String nombre) {
        List<Ingrediente> caloriesList = loadDatabase();
        Ingrediente result = null;
        if (caloriesList != null) {
            Optional<Ingrediente> item = caloriesList.stream().filter(ingredientes -> ingredientes.getNombre().equals(nombre)).findFirst();
            if (item.isPresent()){
                result = item.get();
            }
        }
        return result;
    }

    private List<Ingrediente> loadDatabase() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:foods.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Ingrediente>> typeRef = new TypeReference<>() {};
        List<Ingrediente> ingredientes = null;
        try {
            ingredientes = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ingredientes;
    }
}


