package com.spring3.clase3spring.Services;

import com.spring3.clase3spring.Entities.CharacterSW;
import com.spring3.clase3spring.Repositories.IStarWarsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StarWarsService implements IStarWarsService{

    @Autowired
    IStarWarsRepository iStarWarsRepository;

    @Override
    public List<CharacterSW> findByName(String name) {
        return iStarWarsRepository.findByName(name);
    }
}
