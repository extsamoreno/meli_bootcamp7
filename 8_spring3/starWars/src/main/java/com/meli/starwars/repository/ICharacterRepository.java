package com.meli.starwars.repository;

import com.meli.starwars.domain.MovieCharacter;

import java.util.List;

public interface ICharacterRepository {
    public List<MovieCharacter> findCharactersByNameContaining(String name);
}
