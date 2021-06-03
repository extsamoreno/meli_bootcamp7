package com.example.starWars.repositories;

import com.example.starWars.services.entities.CharacterEnt;

import java.util.List;

public interface IStarWarsRepository {
    List<CharacterEnt> loadDatabase();
}
