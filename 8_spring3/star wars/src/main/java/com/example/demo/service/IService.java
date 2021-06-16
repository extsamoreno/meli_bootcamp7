package com.example.demo.service;

import com.example.demo.service.dto.CharacterDTO;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IService {

    List<CharacterDTO> getCharacters(String name);
}
