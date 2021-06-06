package com.starwars.api.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.starwars.api.model.MovieCharacter;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StarWarsRepositoryImpl implements IStarWarsRepository {

    @Override
    public List<MovieCharacter> findCharactersByName(String name) {

        List<MovieCharacter> allMovieCharacters = loadDataBase();

        List<MovieCharacter> result = new ArrayList<>();

        if (allMovieCharacters != null) {
            for (MovieCharacter charEntity : allMovieCharacters) {
                if (charEntity.getName().contains(name)) {
                    result.add(charEntity);
                }
            }
        }
        return result;
    }

    private List<MovieCharacter> loadDataBase() {

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
