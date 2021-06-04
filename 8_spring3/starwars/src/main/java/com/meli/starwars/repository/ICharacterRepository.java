package com.meli.starwars.repository;

import com.meli.starwars.entity.MovieCharacter;

import java.util.List;

public interface ICharacterRepository {

    public List<MovieCharacter> findCharactersByNameContaining(String name);

}
