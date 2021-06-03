package com.starWars;

import com.starWars.repositories.iStarWarsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StarWarsService implements iStarWarsService {

    @Autowired
    iStarWarsRepository iStarWarsRepository;

    @Override
    public List<CharacterDTO> getCharactersByName(String word) {
        List<CharacterDTO> characterDTOS = iStarWarsRepository.loadDataBase();
        return characterDTOS.stream().filter(p -> p.getName().contains(word)).collect(Collectors.toList());
    }
}
