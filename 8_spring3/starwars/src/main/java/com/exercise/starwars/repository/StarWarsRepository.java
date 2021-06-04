package com.exercise.starwars.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
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
    public List<Character> findCharacterByName(String name) {
        List<Character> characterList = null;
        characterList = loadDataBase();
        List<Character> result = null;
        if (characterList != null) {

            result = characterList.stream()
                    .filter(character -> character.getName().toLowerCase().contains(name.toLowerCase()))
                    .collect(Collectors.toList());

        }
        return result;
    }

    private List<Character> loadDataBase() {
        File file = null;
        try {
            file = ResourceUtils.getFile("src/main/resources/static/starwars.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Character>> typeRef = new TypeReference<>() {};
        List<Character> characterList = null;
        try {
            characterList = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return characterList;
    }
}

