package com.example._spring3.service;

import com.example._spring3.dto.CharacterDTO;
import com.example._spring3.entity.MovieCharacter;
import com.example._spring3.repository.IStarWarsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StarWarsService implements IStarWarsService{
    @Autowired
    IStarWarsRepository iStarWarsRepository;

    @Override
    public List<MovieCharacter> getCharacterByName(String name) {
        return iStarWarsRepository.getCharacterByName(name);
    }
}
