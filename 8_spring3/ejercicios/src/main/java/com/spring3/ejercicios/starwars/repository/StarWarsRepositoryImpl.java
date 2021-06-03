package com.spring3.ejercicios.starwars.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StarWarsRepositoryImpl implements IStarWarsRepository{

    @Override
    public ArrayList<CharacterSW> findCharactersSWByName(String name) {
        List<CharacterSW> charactesSWDataBase;
        ArrayList<CharacterSW> charactesSWFounded = new ArrayList<>();
        charactesSWDataBase = loadDateBase();
        for (CharacterSW x : charactesSWDataBase ) {
            if (x.getName().contains(name)) {
                charactesSWFounded.add(x);
            }
        }
        return charactesSWFounded;
    }

    private List<CharacterSW> loadDateBase() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:starwars.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper om = new ObjectMapper();
        TypeReference<List<CharacterSW>> typeDef = new TypeReference<>() {
        };
        List<CharacterSW> characterSWList = null;
        try {
            characterSWList = om.readValue(file, typeDef);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return characterSWList;
    }

}
