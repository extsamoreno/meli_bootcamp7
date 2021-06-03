package com.meli.starwars.repository;

import com.meli.starwars.domain.Character;
import java.util.List;

public interface ICharacterRepository {
    List<Character> getCharacterByName(String name);
}
