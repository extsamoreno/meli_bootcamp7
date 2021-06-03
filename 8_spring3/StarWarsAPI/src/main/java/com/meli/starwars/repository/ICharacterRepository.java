package com.meli.starwars.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@Repository
public class ICharacterRepository implements CharacterRepository{
    @Override
    public List<Character> getCharacters() {
        return charactersfromDatabase();
    }

    private List<Character> charactersfromDatabase() {
        File file=null;
        try{
            file= ResourceUtils.getFile("/Users/mirivera/Documents/meli_bootcamp7/8_spring3/StarWarsAPI/src/main/resources/starwars.json");

        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
        ObjectMapper objectMapper= new ObjectMapper();
        TypeReference<List<Character>> typeReference= new TypeReference<>() {};
        List<Character> character=null;
        try{
            character = objectMapper.readValue(file, typeReference);
        } catch (IOException e){
            e.printStackTrace();
        }
        return character;
    }
}
