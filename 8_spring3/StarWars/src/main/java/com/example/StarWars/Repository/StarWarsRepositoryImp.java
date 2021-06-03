package com.example.StarWars.Repository;

import com.example.StarWars.Domain.CharacterDTO;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class StarWarsRepositoryImp implements iStarWarsRepository {

    @Override
    public List<CharacterDTO> findCharacterbyName(String name) {

        List<CharacterDTO> listCharacterDTOS = loadDatase();
        List<CharacterDTO> listResult = null;

        if(listCharacterDTOS != null){
            listResult = listCharacterDTOS.stream().filter(i -> i.getName().toLowerCase().contains(name.toLowerCase())).collect(Collectors.toList());
        }
        return listResult;
    }

    private List<CharacterDTO> loadDatase() {

        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:starwars.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<CharacterDTO>> typeRef = new TypeReference<>() {};
        List<CharacterDTO> listCharactersDTOS = null;

        try {
            listCharactersDTOS = objectMapper.readValue(file, typeRef);
        } catch(IOException e) {
            e.printStackTrace();
        }
        return listCharactersDTOS;
    }
}
