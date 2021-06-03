package com.example.starWars.repositories;

import com.example.starWars.services.entities.CharacterEnt;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@Repository
public class StarWarsRepository implements IStarWarsRepository{
    @Override
    public List<CharacterEnt> loadDatabase() {
        File file = null;

        try {
            file = ResourceUtils.getFile("classpath:starwars.json");
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            file = null;
        }
        ObjectMapper objectMapper = new ObjectMapper();

        TypeReference<List<CharacterEnt>> typeReference = new TypeReference<>() {};
        List<CharacterEnt> characters = null;
        try {
            characters = objectMapper.readValue(file, typeReference);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return characters;
    }
}
