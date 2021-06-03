package com.spring3.ejercicios.starwars.service;

import com.spring3.ejercicios.starwars.repository.CharacterSW;
import com.spring3.ejercicios.starwars.repository.IStarWarsRepository;
import com.spring3.ejercicios.starwars.service.dto.NamesCharactersSWDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class StarWarsServiceImpl implements IStarWarsService{
    private NamesCharactersSWDTO namesCharactersSWDTO = new NamesCharactersSWDTO();

    @Autowired
    IStarWarsRepository iStarWarsRepository;

    @Override
    public NamesCharactersSWDTO mapper(String name) {

        ArrayList<CharacterSW> chacterSWFounded = iStarWarsRepository.findCharactersSWByName(name);
        ArrayList<String> listOfNames = new ArrayList<>();
        for (CharacterSW x : chacterSWFounded) {
           listOfNames.add(x.getName());
        }
        namesCharactersSWDTO.setListCharacters(listOfNames);
        return namesCharactersSWDTO;
    }
}
