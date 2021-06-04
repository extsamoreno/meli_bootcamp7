package com.clase3spring.demo.starwars.repositories;

import com.clase3spring.demo.starwars.repositories.entities.Character;

import java.util.ArrayList;
import java.util.List;

public interface ICharacterRepository {
    List<Character> findByName(String name);
}
