package com.clase3spring.demo.starwars.repositories;

import com.clase3spring.demo.calculatorCalories.models.CalorieDTO;
import com.clase3spring.demo.starwars.models.CharacterDTO;
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

@Repository
public class CharacterRepository implements ICharacterRepository{

    @Override
    public ArrayList<CharacterDTO> findByName(String name) {
        List<CharacterDTO> character = null;
        character = loadDatabase();
        ArrayList<CharacterDTO> result = new ArrayList<CharacterDTO>();
        if(character != null){
            Optional<CharacterDTO> item = character.stream()
                    .filter(ch -> ch.getName().contains(name))
                    .findAny();
            if(item.isPresent()){
                result.add(item.get());
            }
        }

        return result;
    }

    private List<CharacterDTO> loadDatabase(){
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:starwars.json");
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<CharacterDTO>> typeRef = new TypeReference<>(){};
        List<CharacterDTO> chDTO = null;

        try{
            chDTO = objectMapper.readValue(file, typeRef);
        }catch (IOException e){
            e.printStackTrace();
        }

        return chDTO;
    }
}
