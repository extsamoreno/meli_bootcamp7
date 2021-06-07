package com.example.demo.project.excercise2.repository;

import com.example.demo.project.excercise1.repository.entities.Ingrediente;
import com.example.demo.project.excercise2.repository.entities.CharacterSW;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.UnaryOperator;

@Repository
public class CharacterRepository implements ICharacterRepository {

    private ArrayList<CharacterSW> loadDatabase() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:starwars.json");
            System.out.println("ENCONTRE EL ARCHIVO: " +file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<ArrayList<CharacterSW>> typeRef = new TypeReference<>() {};
        ArrayList<CharacterSW> characterSw = null;
        try {
            characterSw = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return characterSw;
    }

    @Override
    public ArrayList<CharacterSW> getCharacterList() {
        return loadDatabase();
    }
}