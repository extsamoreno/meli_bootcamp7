package com.ejercitacion.ejercitacion.starwars.repository;

import com.ejercitacion.ejercitacion.starwars.entity.StarWarsCharacter;

import java.util.List;

public interface CharacterRepository {

    List<StarWarsCharacter> getCharactersByName(String name);
}
