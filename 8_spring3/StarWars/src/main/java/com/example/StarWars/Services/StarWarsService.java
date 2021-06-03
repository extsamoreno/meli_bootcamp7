package com.example.StarWars.Services;

import com.example.StarWars.Domain.CharacterDTO;
import com.example.StarWars.Repository.iStarWarsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StarWarsService implements iStarWarsService {

    @Autowired
    iStarWarsRepository iSTRepo;

    @Override
    public List<CharacterDTO> findCHbyName(String name) {
        return iSTRepo.findCharacterbyName(name);
    }
}
