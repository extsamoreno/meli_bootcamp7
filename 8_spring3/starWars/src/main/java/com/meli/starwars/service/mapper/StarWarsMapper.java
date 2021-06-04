package com.meli.starwars.service.mapper;

import com.meli.starwars.domain.MovieCharacter;

import java.util.List;
import java.util.stream.Collectors;

public class StarWarsMapper {
    public static MovieCharacterDTO toDTO(MovieCharacter c) {
        return new MovieCharacterDTO(c.getName());
    }

    public static List<MovieCharacterDTO> toListDTO(List<MovieCharacter> list) {
        return list.stream().map(c -> toDTO(c)).collect(Collectors.toList());
    }
}
