package com.example._spring3.service;

import com.example._spring3.dto.CharacterDTO;
import com.example._spring3.entity.MovieCharacter;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IStarWarsService {
    public List<MovieCharacter> getCharacterByName(String name);
}
