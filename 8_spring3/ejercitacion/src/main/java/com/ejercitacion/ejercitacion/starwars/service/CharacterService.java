package com.ejercitacion.ejercitacion.starwars.service;

import com.ejercitacion.ejercitacion.starwars.dto.StarWarsCharacterDTO;

import java.util.List;

public interface CharacterService {

    List<StarWarsCharacterDTO> getCharactersByName(String name);
}
