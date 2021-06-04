package com.meli.starwars.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.starwars.domain.Character;
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
    public List<Character> findCharactersByNameContaining(String name) {

        List<Character> characters = null;
        characters = loadDatabase();

        List<Character> filteredChar = null;
        if (characters != null) {
            filteredChar = characters.stream().filter(c -> nameContaining(c,name)).collect(Collectors.toList());
            List<String> nombres = characters.stream().map(c->c.getName()).collect(Collectors.toList());
        }
        return filteredChar;
    }

    private boolean nameContaining(Character c, String name) {
        return c.getName().toLowerCase().contains(name.toLowerCase());
    }


    private List<Character> loadDatabase() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:starwars.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Character>> typeRef = new TypeReference<>() {
        };
        List<Character> characters = null;
        try {
            characters = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return characters;
    }


}
