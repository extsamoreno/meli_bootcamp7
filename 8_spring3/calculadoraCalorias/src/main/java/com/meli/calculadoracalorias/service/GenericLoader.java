package com.meli.calculadoracalorias.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.calculadoracalorias.domain.Ingredient;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Component
public class GenericLoader<T> {

    public List<Ingredient> loadData() {
        try {
            File file = ResourceUtils.getFile("classpath:food.json");
            ObjectMapper objectMapper = new ObjectMapper();
            TypeReference<List<Ingredient>> typeRef = new TypeReference<>() {
            };
            return objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<T> loadData(String pathToFile) {
        try {
            File file = ResourceUtils.getFile(pathToFile);
            ObjectMapper objectMapper = new ObjectMapper();
            TypeReference<List<T>> typeRef = new TypeReference<>() {
            };
            return objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
