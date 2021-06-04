package com.meli.starwars.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.starwars.domain.MovieCharacter;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CharacterRepository implements ICharacterRepository {

    @Override
    public List<MovieCharacter> findCharactersByNameContaining(String name) {

        List<MovieCharacter> movieCharacters = null;
        movieCharacters = loadDatabase();

        List<MovieCharacter> filteredChar = null;
        if (movieCharacters != null) {
            filteredChar = movieCharacters.stream().filter(c -> nameContaining(c,name)).collect(Collectors.toList());
            List<String> nombres = movieCharacters.stream().map(c->c.getName()).collect(Collectors.toList());
        }
        return filteredChar;
    }

    private boolean nameContaining(MovieCharacter c, String name) {
        return c.getName().toLowerCase().contains(name.toLowerCase());
    }


    private List<MovieCharacter> loadDatabase() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:starwars.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<MovieCharacter>> typeRef = new TypeReference<>() {
        };
        List<MovieCharacter> movieCharacters = null;
        try {
            movieCharacters = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return movieCharacters;
    }


}
