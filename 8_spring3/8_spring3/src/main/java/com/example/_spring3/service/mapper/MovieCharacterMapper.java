package com.example._spring3.service.mapper;

import com.example._spring3.dto.MovieCharacterDTO;
import com.example._spring3.entity.MovieCharacter;

import java.util.ArrayList;
import java.util.List;

public class MovieCharacterMapper {

    public static MovieCharacterDTO toDTO(MovieCharacter movCharacter){
        return new MovieCharacterDTO(movCharacter.getName());
    }
    public static List<MovieCharacterDTO> toDTOList(List<MovieCharacter> movCharacter){
        List<MovieCharacterDTO> charDTOList = new ArrayList<>();
        for (MovieCharacter charac : movCharacter) {
            charDTOList.add(new MovieCharacterDTO(charac.getName()));
        }
        return charDTOList;
    }
}
