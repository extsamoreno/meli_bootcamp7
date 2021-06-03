package com.clase3spring.demo.starwars.services;

import com.clase3spring.demo.starwars.models.CharacterDTO;

import java.util.ArrayList;

public interface ICharacterService {
    ArrayList<CharacterDTO> findByName(String name);
}
