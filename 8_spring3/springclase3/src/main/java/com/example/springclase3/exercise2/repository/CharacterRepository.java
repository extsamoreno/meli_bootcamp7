package com.example.springclase3.exercise2.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

@Repository
public class CharacterRepository implements ICharacterRepository{

    private ArrayList<CharacterSW> loadDataBase () {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:starwars.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ObjectMapper om = new ObjectMapper();

        TypeReference<ArrayList<CharacterSW>> typeDef = new TypeReference<>() {
        };
        ArrayList<CharacterSW> characterSWList = null;
        try {
            characterSWList = om.readValue(file, typeDef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return characterSWList;

    }

    @Override
    public ArrayList<CharacterSW> getCharacterList() {
        return loadDataBase();
    }
}
