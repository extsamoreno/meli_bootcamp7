package com.meli.starwars.service;

import com.meli.starwars.service.mapper.MovieCharacterDTO;

import java.util.List;


public interface IStarWarsService {
    public List<MovieCharacterDTO> getCharactersByName(String name);
}
