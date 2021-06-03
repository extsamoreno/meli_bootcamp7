package com.meli.starwars.service;

import com.meli.starwars.domain.Character;
import java.util.List;

public interface IStarWarsService {
    List<Character> findCharactersByName(String name);
}
