package com.spring3.ejercicios.starwars.repository;

import java.util.ArrayList;

public interface IStarWarsRepository {

    ArrayList<CharacterSW> findCharactersSWByName(String name);
}
