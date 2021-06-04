package com.example._spring3.repository;

import com.example._spring3.entity.Ingredient;
import com.example._spring3.entity.MovieCharacter;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Repository
public class StarWarsRepository implements IStarWarsRepository{
    @Override
    public List<MovieCharacter> getCharacterByName(String name) {
        List<MovieCharacter> characterList = loadDatabase();
        List<MovieCharacter> matchesList = new ArrayList<>();

        for (MovieCharacter charac : characterList) {
            if(charac.getName().toUpperCase().contains(name.toUpperCase())){
                matchesList.add(charac);
            }
        }
        return matchesList;
    }

    private List<MovieCharacter> loadDatabase() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:starwars.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<MovieCharacter>> typeRef = new TypeReference<>() {};
        List<MovieCharacter> characters = null;
        try {
            characters = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return characters;
    }
}
