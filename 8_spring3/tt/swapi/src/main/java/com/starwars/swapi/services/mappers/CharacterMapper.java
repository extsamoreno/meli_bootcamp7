package com.starwars.swapi.services.mappers;

import com.starwars.swapi.services.dtos.CharacterDTO;
import com.starwars.swapi.services.entity.Character;

public class CharacterMapper {
    public static CharacterDTO mapToDTO(Character character) {
        return new CharacterDTO(character.getName());
    }
}
