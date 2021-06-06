package com.spring3.starwars.service.mapper;


import com.spring3.starwars.model.Character;
import com.spring3.starwars.service.dto.CharacterDTO;

public class CharacterMapper {
    public static CharacterDTO toDto (Character character) {
        return new CharacterDTO(character.getName(), character.getSpecies());
    }
}
