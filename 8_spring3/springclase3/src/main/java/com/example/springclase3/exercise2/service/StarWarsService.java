package com.example.springclase3.exercise2.service;

import com.example.springclase3.exercise2.repository.CharacterSW;
import com.example.springclase3.exercise2.repository.ICharacterRepository;
import com.example.springclase3.exercise2.service.mapper.StarWarsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StarWarsService implements IStarWarsService{

    @Autowired
    ICharacterRepository iCharacterRepository;

    @Override
    public ArrayList<String> getCharacterDTO(String name) {
        return StarWarsMapper.toStrArr(findMatchingName(name));
    }

    @Override
    public ArrayList<CharacterSW> test() {

        return iCharacterRepository.getCharacterList();
    }

    private List<CharacterSW> findMatchingName(String name){
        List<CharacterSW> items = iCharacterRepository.getCharacterList().stream()
                .filter(characterSW-> characterSW.getName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
        return items;
    }
}
