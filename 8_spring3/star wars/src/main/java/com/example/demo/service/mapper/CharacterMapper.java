package com.example.demo.service.mapper;

import com.example.demo.repository.CharacterSW;
import com.example.demo.service.dto.CharacterDTO;
import org.springframework.stereotype.Component;


public class CharacterMapper {

    public static CharacterDTO mapToDTO(CharacterSW characterSW) {
        return new CharacterDTO(characterSW.getName());
    }

}
