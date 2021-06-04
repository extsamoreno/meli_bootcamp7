package com.meli.starwars.service;

import com.meli.starwars.repository.ICharacterRepository;
import com.meli.starwars.service.mapper.MovieCharacterDTO;
import com.meli.starwars.service.mapper.StarWarsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StarWarsService implements IStarWarsService {

    @Autowired
    ICharacterRepository characterRepository;

    @Override
    public List<MovieCharacterDTO> getCharactersByName(String name) {
        return StarWarsMapper.toListDTO(
                characterRepository.findCharactersByNameContaining(name)
        );
    }

}
