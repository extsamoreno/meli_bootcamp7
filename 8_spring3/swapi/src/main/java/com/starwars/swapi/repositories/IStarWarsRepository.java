package com.starwars.swapi.repositories;

import com.starwars.swapi.services.entity.Character;

import java.util.List;

public interface IStarWarsRepository {
    List<Character> loadDatabase();

}
