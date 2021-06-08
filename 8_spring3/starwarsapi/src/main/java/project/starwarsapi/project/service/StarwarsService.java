package project.starwarsapi.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.starwarsapi.project.repository.IStarwarsRepository;
import project.starwarsapi.project.service.DTO.StarwarsRequestDTO;
import project.starwarsapi.project.service.DTO.StarwarsResponseDTO;
import project.starwarsapi.project.service.Mapper.StarwarsMapper;


@Service
public class StarwarsService implements IStarwarsService{
    @Autowired
    IStarwarsRepository iStarwarsRepository;

    public StarwarsResponseDTO getCharacters (StarwarsRequestDTO starwarsRequestDTO){
        return StarwarsMapper.toDTO(iStarwarsRepository.getCharactersByName(starwarsRequestDTO.getName()));
    }


}

