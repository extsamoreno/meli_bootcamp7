package com.example.starWars.services.mappers;

import com.example.starWars.services.dtos.CharacterDTO;
import com.example.starWars.services.entities.CharacterEnt;

public class CharacterMapper {
    public static CharacterDTO mapToDTO(CharacterEnt character){
        return new CharacterDTO(character.getName());
    }
}
