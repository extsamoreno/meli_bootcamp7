package project.starwarsapi.project.service.Mapper;

import project.starwarsapi.project.repository.StarwarsCharacter;
import project.starwarsapi.project.service.DTO.StarwarsResponseDTO;

import java.util.ArrayList;

public class StarwarsMapper {
    public static StarwarsResponseDTO toDTO(ArrayList<StarwarsCharacter> starwarsCharacter){
        StarwarsResponseDTO starwarsResponseDTOList = new StarwarsResponseDTO();
        for (StarwarsCharacter item : starwarsCharacter) {
            starwarsResponseDTOList.getNameList().add(item.getName());
        }

        return starwarsResponseDTOList;
    }

/*    public static StarwarsCharacter toStarwarsCharacter(StarwarsResponseDTO starwarsResponseDTO){

        return new StarwarsCharacter(starwarsCharacter.getName(), starwarsCharacter.getStock());
    }*/
}
