package com.spring3.clase3spring.Services;

import com.spring3.clase3spring.Entities.CharacterSW;

import java.util.List;

public interface IStarWarsService {
    List<CharacterSW> findByName(String name);
}
