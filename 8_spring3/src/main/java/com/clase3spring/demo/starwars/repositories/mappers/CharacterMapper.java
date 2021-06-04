package com.clase3spring.demo.starwars.repositories.mappers;

import com.clase3spring.demo.starwars.models.CharacterDTO;
import com.clase3spring.demo.starwars.repositories.entities.Character;

import java.util.ArrayList;
import java.util.List;

public class CharacterMapper {

    public static ArrayList<CharacterDTO> characterToDTO(List<Character> chList){
        ArrayList<CharacterDTO> charactersDTO = new ArrayList<CharacterDTO>();
        for (Character ch: chList) {
            CharacterDTO chDTo = new CharacterDTO();
            chDTo.setName(ch.getName());
            charactersDTO.add(chDTo);
        }

        return charactersDTO;
    }
}
