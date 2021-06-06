package com.starwars.api.mapper;

import com.starwars.api.dto.MovieCharacterDTO;
import com.starwars.api.model.MovieCharacter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MovieCharacterMapper {

    public List<MovieCharacterDTO> mapToDTO(List<MovieCharacter> characterEntities) {

        List<MovieCharacterDTO> characterDTOS = new ArrayList<>();

        for (MovieCharacter entity : characterEntities) {
            characterDTOS.add(mapEach(entity));
        }
        return characterDTOS;
    }

    private MovieCharacterDTO mapEach(MovieCharacter movieCharacter) {

        MovieCharacterDTO movieCharacterDTO = new MovieCharacterDTO();
        movieCharacterDTO.setName(movieCharacter.getName());

        return movieCharacterDTO;
    }
}
