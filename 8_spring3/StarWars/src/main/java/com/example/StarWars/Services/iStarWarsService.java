package com.example.StarWars.Services;

import com.example.StarWars.Domain.CharacterDTO;

import java.util.List;

public interface iStarWarsService {

    List<CharacterDTO> findCHbyName(String name);
}
