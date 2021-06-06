package com.spring3.starwars.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring3.starwars.model.Character;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class CharacterRepositoryImpl implements CharacterRepository {

    @Override
    public List<Character> findCharacterByName(String name) {
        List<Character> allCharacters = null;
        allCharacters = loadDataBase();
        Character result = null;
        if (allCharacters != null) {
            return  allCharacters.stream()
                    .filter(character -> character.getName().toLowerCase().contains(name))
                    .collect(Collectors.toList());
        } else {
            return allCharacters;
        }
    }

    private List<Character> loadDataBase() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:starwars.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Character>> typeRef = new TypeReference<>() {};
        List<Character> allCharacters = null;
        try {
            allCharacters = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return allCharacters;
    }
}

