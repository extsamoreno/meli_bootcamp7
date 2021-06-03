package com.meli.spring.PracticaTarde.Services;

import com.meli.spring.PracticaTarde.Dto.CharacterDto;

import java.util.List;

public interface CharacterService {
    List<CharacterDto> findMatches(String chunk);
}
