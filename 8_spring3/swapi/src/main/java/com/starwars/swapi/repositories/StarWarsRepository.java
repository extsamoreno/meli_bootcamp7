package com.starwars.swapi.repositories;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.starwars.swapi.services.entity.Character;
import com.starwars.swapi.services.mappers.CharacterMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class StarWarsRepository implements IStarWarsRepository {

    @Override
    public List<Character> getCharactersByName(String name) {

        List<Character> characterList = loadDatabase().stream()
                .filter(character -> character.getName().contains(name))
                .collect(Collectors.toList());
        return characterList;
    }

    private List<Character> loadDatabase() {
        File file = null;

        try {
            file = ResourceUtils.getFile("classpath:starwars.json");
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            file = null;
        }
        ObjectMapper objectMapper = new ObjectMapper();

        TypeReference<List<Character>> typeReference = new TypeReference<>() {};
        List<Character> characters = null;
        try {
            characters = objectMapper.readValue(file, typeReference);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return characters;
    }
}
