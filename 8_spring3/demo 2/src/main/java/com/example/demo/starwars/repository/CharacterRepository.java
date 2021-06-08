package com.example.demo.starwars.repository;

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
import java.util.stream.Stream;

@Repository
public class CharacterRepository implements ICharacterRepository{
    @Override
    public ArrayList<CharacterStarWars> getCharacter(String name) {
        List<CharacterStarWars> characterStarWarsDTO = null;
        ArrayList<CharacterStarWars> arrayList = new ArrayList();
        characterStarWarsDTO = loadDatabase();
        if (characterStarWarsDTO != null) {
            for (CharacterStarWars characterStarWars:characterStarWarsDTO) {
                if (characterStarWars.getName().matches(".*"+name+".*")){
                    arrayList.add(characterStarWars);
                }
            }
        }
        return arrayList;
    }
    private List<CharacterStarWars> loadDatabase() {
        File file = null;
        try {
            file = ResourceUtils.getFile("src/main/resources/static/starwars.json");
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<CharacterStarWars>> typeReference = new TypeReference<>() {};
        List<CharacterStarWars> characterStarWars = null;
        try {
            characterStarWars =  objectMapper.readValue(file,typeReference);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return characterStarWars;

    }
    }

