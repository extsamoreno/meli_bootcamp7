package com.starwars.swapi.services.mappers;

import com.starwars.swapi.services.dtos.CharacterDTO;
import com.starwars.swapi.services.entity.Character;

import java.util.ArrayList;
import java.util.List;

public class CharacterMapper {
    public static CharacterDTO mapToDTO(Character character) {
        return new CharacterDTO(character.getName());
    }

    public static List<CharacterDTO> mapListToDTOs(List<Character> characters) {
        List<CharacterDTO> characterDTOList = new ArrayList<>();

        for (Character character :
                characters) {
            characterDTOList.add(mapToDTO(character));
        }

        return characterDTOList;
    }
}
