package com.meli.API_star_wars.repositories;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.API_star_wars.service.dto.CharacterDTO;
import com.meli.API_star_wars.service.dto.CharacterResDTO;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@org.springframework.stereotype.Repository
public class RepositoryImpl implements Repository{

    @Override
    public ArrayList<CharacterResDTO> returnCharacters(String name) {
        List<CharacterDTO> characterDTOList = null;
        characterDTOList = loadDataBase();
        ArrayList<CharacterResDTO> characterResDTOArrayList = new ArrayList<>();
        for (CharacterDTO character: characterDTOList) {
            if (character.getName().toUpperCase(Locale.ROOT).indexOf(name.toUpperCase()) != -1) {
                characterResDTOArrayList.add(new CharacterResDTO(character.getName()));
            }
        }
        return characterResDTOArrayList;
    }

    private List<CharacterDTO> loadDataBase() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:starwars.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<CharacterDTO>> typeRef = new TypeReference<>() {};
        List<CharacterDTO> characterDTOList = null;
        try {
            characterDTOList = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  characterDTOList;
    }
}
