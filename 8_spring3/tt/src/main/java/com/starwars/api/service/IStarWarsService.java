package com.starwars.api.service;

import com.starwars.api.dto.MovieCharacterDTO;

import java.util.List;

public interface IStarWarsService {

    List<MovieCharacterDTO> getMovieCharacters(String name);

}
