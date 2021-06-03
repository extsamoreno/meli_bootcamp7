package com.example.CalCalculator.project.Service;

import com.example.CalCalculator.project.Service.dto.CharacterDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ICharacterService {

    public List<CharacterDTO> getByName(String name);
}
