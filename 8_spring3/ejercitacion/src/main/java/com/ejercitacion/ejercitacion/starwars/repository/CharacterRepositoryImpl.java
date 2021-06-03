package com.ejercitacion.ejercitacion.starwars.repository;

import com.ejercitacion.ejercitacion.starwars.entity.StarWarsCharacter;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CharacterRepositoryImpl implements CharacterRepository {

    @Override
    public List<StarWarsCharacter> getCharactersByName(String name) {
        List<StarWarsCharacter> characters = loadDatabase();
        List<StarWarsCharacter> result = new ArrayList<>();
        if (characters != null) {
           result = characters.stream().filter(c -> c.getName().toUpperCase().replaceAll("\\s", "")
                               .contains(name.toUpperCase().replaceAll("\\s", ""))).collect(Collectors.toList());
        }
        return result;
    }

    private List<StarWarsCharacter> loadDatabase() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:starwars.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<StarWarsCharacter>> typeRef = new TypeReference<>() {};
        List<StarWarsCharacter> characters = null;

        try {
            characters = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return characters;
    }
}
