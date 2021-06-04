package starwars.service.mapper;

import starwars.entity.MovieCharacter;
import starwars.service.dto.MovieCharacterDTO;

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
