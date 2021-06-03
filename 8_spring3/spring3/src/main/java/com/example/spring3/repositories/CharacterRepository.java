package com.example.spring3.repositories;

import com.example.spring3.classes.Character;
import com.example.spring3.classes.Ingredient;
import com.example.spring3.repositories.interfaces.ICharacterRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Repository
public class CharacterRepository implements ICharacterRepository {

    @Override
    public List<Character> findCharacterByPortionName(String name) {
        List<Character> characterList = null;
        characterList = loadDateBase();
        List<Character> result = new ArrayList<>();
        if(characterList != null) {
            for(Character c : characterList) {
                if(Pattern.compile(Pattern.quote(name), Pattern.CASE_INSENSITIVE).matcher(c.getName()).find()) {
                    result.add(c);
                }
            }
        }
        return result;
    }

    private List<Character> loadDateBase() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:starwars.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Character>> typeRef = new TypeReference<>(){};
        List<Character>  characterList = null;
        try {
            characterList = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return characterList;
    }
}
