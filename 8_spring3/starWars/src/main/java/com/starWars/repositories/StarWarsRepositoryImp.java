package com.starWars.repositories;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.starWars.CharacterDTO;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@Repository
public class StarWarsRepositoryImp implements iStarWarsRepository{

    public List<CharacterDTO> loadDataBase() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:starwars.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<CharacterDTO>> typeRef = new TypeReference<>() {};
        List<CharacterDTO> CharacterDTOS = null;

        try {
            CharacterDTOS = objectMapper.readValue(file, typeRef);
        } catch(IOException e) {
            e.printStackTrace();
        }
        return CharacterDTOS;
    }

}
