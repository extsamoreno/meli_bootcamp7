package com.example.CalCalculator.project.Service;

import com.example.CalCalculator.project.Repository.ICharacterRepository;
import com.example.CalCalculator.project.Service.dto.CharacterDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CharacterService implements ICharacterService{
    @Autowired
    ICharacterRepository iCharacterRepository;

    @Override
    public List<CharacterDTO> getByName(String name){

        return iCharacterRepository.getByName(name);
    }
}
