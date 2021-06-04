package com.clase3spring.demo.starwars.repositories;

import com.clase3spring.demo.calculatorCalories.models.CalorieDTO;
import com.clase3spring.demo.starwars.repositories.entities.Character;
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
public class CharacterRepository implements ICharacterRepository{

    @Override
    public List<Character> findByName(String name) {
        List<Character> character = null;
        character = loadDatabase();
        List<Character> result = null;
        if(character != null){
            List<Character> item = character.stream()
                    .filter(ch -> ch.getName().contains(name))
                    .collect(Collectors.toList());
            if(!item.isEmpty()){
                result = item;
            }
        }

        return result;
    }

    private List<Character> loadDatabase(){
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:starwars.json");
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Character>> typeRef = new TypeReference<>(){};
        List<Character> character = null;

        try{
            character = objectMapper.readValue(file, typeRef);
        }catch (IOException e){
            e.printStackTrace();
        }

        return character;
    }
}
