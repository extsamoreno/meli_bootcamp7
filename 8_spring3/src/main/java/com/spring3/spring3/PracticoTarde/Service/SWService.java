package com.spring3.spring3.PracticoTarde.Service;

import com.spring3.spring3.PracticoTarde.DTO.CharacterDTO;
import com.spring3.spring3.PracticoTarde.Classes.SWCharacter;
import com.spring3.spring3.PracticoTarde.Repository.IStarWarsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SWService implements ISWService{
    @Autowired
    IStarWarsRepository istarWarsRepository;

    @Override
    public List<CharacterDTO> findByName(String name) {
        List<CharacterDTO> charactersDTO = new ArrayList<>();
        List<SWCharacter> swCharacters = istarWarsRepository.findAll();
        for (SWCharacter c : swCharacters) {
            if (c.getName().contains(name)) {
                charactersDTO.add(new CharacterDTO(c.getName()));
            }
        }
        return charactersDTO;
    }
}
