package com.example.StarWars.Repository;

import com.example.StarWars.Domain.CharacterDTO;

import java.util.List;

public interface iStarWarsRepository {
    List<CharacterDTO> findCharacterbyName(String name);
}
