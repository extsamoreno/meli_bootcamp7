package com.clase3spring.demo.starwars.repositories;

import com.clase3spring.demo.starwars.models.CharacterDTO;

import java.util.ArrayList;

public interface ICharacterRepository {
    ArrayList<CharacterDTO> findByName(String name);
}
