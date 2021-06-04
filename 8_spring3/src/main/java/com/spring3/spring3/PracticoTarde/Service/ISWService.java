package com.spring3.spring3.PracticoTarde.Service;

import com.spring3.spring3.PracticoTarde.DTO.CharacterDTO;

import java.util.List;

public interface ISWService {
    public List<CharacterDTO> findByName(String name);
}
