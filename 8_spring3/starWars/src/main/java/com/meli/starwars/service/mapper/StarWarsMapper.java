package com.meli.starwars.service.mapper;

import com.meli.starwars.domain.Character;

import java.util.List;
import java.util.stream.Collectors;

public class StarWarsMapper {
    public static CharacterDTO toDTO(Character c) {
        return new CharacterDTO(c.getName());
    }

    public static List<CharacterDTO> toListDTO(List<Character> list) {
        return list.stream().map(c -> toDTO(c)).collect(Collectors.toList());
    }
}
