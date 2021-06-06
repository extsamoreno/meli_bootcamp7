package com.starwars.api.service;

import com.starwars.api.dto.MovieCharacterDTO;
import com.starwars.api.mapper.MovieCharacterMapper;
import com.starwars.api.repository.StarWarsRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StarWarsService implements IStarWarsService{

    @Autowired
    private StarWarsRepositoryImpl starWarsRepository;

    @Autowired
    private MovieCharacterMapper movieCharacterMapper;

    public List<MovieCharacterDTO> getMovieCharacters (String name){

        return movieCharacterMapper.mapToDTO(starWarsRepository.findCharactersByName(name));
    }
}
