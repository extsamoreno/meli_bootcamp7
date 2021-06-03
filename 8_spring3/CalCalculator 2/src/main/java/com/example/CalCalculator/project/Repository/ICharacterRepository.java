package com.example.CalCalculator.project.Repository;

import com.example.CalCalculator.project.Service.dto.CharacterDTO;

import java.util.List;

public interface ICharacterRepository {

    public List<CharacterDTO> getByName(String name);
}
