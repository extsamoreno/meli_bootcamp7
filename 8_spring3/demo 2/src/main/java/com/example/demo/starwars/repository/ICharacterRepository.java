package com.example.demo.starwars.repository;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
@Repository
public interface ICharacterRepository {
    ArrayList<CharacterStarWars> getCharacter(String name);
}
