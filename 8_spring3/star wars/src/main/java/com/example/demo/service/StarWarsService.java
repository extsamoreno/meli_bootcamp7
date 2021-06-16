package com.example.demo.service;

import com.example.demo.repository.CharacterSW;
import com.example.demo.repository.IStarWarsRepo;
import com.example.demo.service.dto.CharacterDTO;
import com.example.demo.service.mapper.CharacterMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StarWarsService implements IService {

    @Autowired
    IStarWarsRepo swRepo;

    CharacterMapper characterMapper;

    @Override
    public List<CharacterDTO> getCharacters(String name) {

        List <CharacterSW> charList = swRepo.loadDataBase();
        List <CharacterDTO> finalList = new ArrayList<>();

        for(CharacterSW c : charList){
            if(c.getName().contains(name)){
                finalList.add(characterMapper.mapToDTO(c));
            } else {
                return null;
            }
        }
        return finalList;
    }
}
