package com.meli.spring.PracticaTarde.Services;

import com.meli.spring.PracticaTarde.Classes.CharacterSW;
import com.meli.spring.PracticaTarde.Dto.CharacterDto;
import com.meli.spring.PracticaTarde.Repository.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Service
public class CharacterServiceImpl implements CharacterService {

    @Autowired
    CharacterRepository characterRepository;
    
    @Override
    public List<CharacterDto> findMatches(String chunk) {
        List<CharacterSW> characterList = characterRepository.findAll();
        List<CharacterDto> result = new ArrayList<>();

        for(CharacterSW characterSW : characterList){
            if(characterSW.getName().toLowerCase(Locale.ROOT).contains(chunk.toLowerCase(Locale.ROOT))){
                result.add(new CharacterDto(characterSW.getName()));
            }
        }

        return result;
    }
}
