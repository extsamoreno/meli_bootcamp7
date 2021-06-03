package com.spring3.clase3spring.Repositories;

import com.spring3.clase3spring.Entities.CharacterSW;

import java.util.List;

public interface IStarWarsRepository {
    List<CharacterSW> findByName(String name);
}
