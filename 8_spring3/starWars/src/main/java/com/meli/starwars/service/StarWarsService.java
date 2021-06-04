package com.meli.starwars.service;

import com.meli.starwars.domain.Character;
import com.meli.starwars.repository.ICharacterRepository;
import com.meli.starwars.service.mapper.CharacterDTO;
import com.meli.starwars.service.mapper.StarWarsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StarWarsService implements IStarWarsService {

    @Autowired
    ICharacterRepository characterRepository;

    @Override
    public List<CharacterDTO> getCharactersByName(String name) {
        return StarWarsMapper.toListDTO(
                characterRepository.findCharactersByNameContaining(name)
        );
    }

}
