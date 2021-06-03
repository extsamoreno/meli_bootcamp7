package com.spring3.ejercicios.starwars.service;

import com.spring3.ejercicios.starwars.service.dto.NamesCharactersSWDTO;

public interface IStarWarsService {

    NamesCharactersSWDTO mapper(String name);
}
