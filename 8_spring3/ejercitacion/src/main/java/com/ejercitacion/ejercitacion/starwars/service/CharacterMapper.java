package com.ejercitacion.ejercitacion.starwars.service;

import com.ejercitacion.ejercitacion.starwars.dto.StarWarsCharacterDTO;
import com.ejercitacion.ejercitacion.starwars.entity.StarWarsCharacter;

public class CharacterMapper {

    public static StarWarsCharacterDTO toDTO(StarWarsCharacter character) {
        return new StarWarsCharacterDTO(character.getName(), character.getHeight(), character.getMass(),
                                        character.getHairColor(), character.getSkinColor(), character.getEyeColor(),
                                        character.getBirthYear(), character.getGender(), character.getHomeworld(),
                                        character.getSpecies());
    }

    public static StarWarsCharacter toEntity(StarWarsCharacterDTO character) {
        return new StarWarsCharacter(character.getName(), character.getHeight(), character.getMass(),
                                     character.getHairColor(), character.getSkinColor(), character.getEyeColor(),
                                     character.getBirthYear(), character.getGender(), character.getHomeworld(),
                                     character.getSpecies());

    }
}
