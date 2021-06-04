package com.example.demo.repository;

import com.example.demo.domains.Character;
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
import java.util.stream.Collectors;

@Repository
public class CharacterRepository implements ICharactersRepository{

    @Override
    public List<Character> getByName(String name) {

        List<Character> characters = loadDataBase();
        List<Character> result = new ArrayList<Character>();

        if (characters != null){
            result = characters.stream()
                    .filter(character -> character.getName().contains(name))
                    .collect(Collectors.toList());
        }

        return result;
    }

    private List<Character> loadDataBase() {
        File file = null;
        try{
            file = ResourceUtils.getFile("classpath:starwars.json");
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }

        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Character>> typeRef = new TypeReference<>() {};

        List<Character> character = null;

        try {
            character = objectMapper.readValue(file, typeRef);
        } catch (IOException e){
            e.printStackTrace();
        }
        return character;
    }
}

