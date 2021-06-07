package com.example.demo.project.excercise1.repository;

import com.example.demo.project.excercise1.repository.entities.Ingrediente;
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
    public Ingrediente getById(String name) {
        List<Ingrediente> ingredienteList = loadDatabase();
        Ingrediente result = null;
        if (ingredienteList != null) {
            Optional<Ingrediente> item = ingredienteList.stream().filter(calories -> calories.getName().equals(name)).findFirst();
            if (item.isPresent()){
                result = item.get();
            }
        }
        return result;
    }
    private List<Ingrediente> loadDatabase() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:food.json");
            System.out.println("ENCONTRE EL ARCHIVO: " +file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Ingrediente>> typeRef = new TypeReference<>() {};
        List<Ingrediente> ingrediente = null;
        try {
            ingrediente = objectMapper.readValue(file, typeRef);
            System.out.println("PUTO " + ingrediente.get(0).getName());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ingrediente;
    }
}