package com.starwars.api.repository;

import com.starwars.api.model.MovieCharacter;

import java.util.List;

public interface IStarWarsRepository {

    List<MovieCharacter> findCharactersByName(String name);
}
