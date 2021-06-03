package com.spring.exercise.starwars.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.exercise.starwars.model.CharacterSW;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CharacterRepository implements ICharacterRepository{

    @Override
    public List<CharacterSW> getCharacterByName(String name) {

        List<CharacterSW> listCharacters = null;
        listCharacters = loadDataBase();
        List<CharacterSW> listCharacterResult = null;

        if(listCharacters != null){
            listCharacterResult = listCharacters.stream().filter(i -> i.getName().toLowerCase().contains(name.toLowerCase())).collect(Collectors.toList());
        }
        return listCharacterResult;
    }


    private List<CharacterSW> loadDataBase() {
        File file = null;

        try {
            file = ResourceUtils.getFile("classpath:starwars.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<CharacterSW>> typeRef = new TypeReference<>() {};
        List<CharacterSW> listCharacters = null;

        try{
            listCharacters = objectMapper.readValue(file , typeRef);
        }catch (IOException e){
            e.printStackTrace();
        }
        return listCharacters;
    }


}
