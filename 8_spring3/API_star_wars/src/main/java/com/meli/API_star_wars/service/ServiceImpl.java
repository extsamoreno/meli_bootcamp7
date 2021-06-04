package com.meli.API_star_wars.service;

import com.meli.API_star_wars.repositories.RepositoryImpl;
import com.meli.API_star_wars.service.dto.CharacterResDTO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

@org.springframework.stereotype.Service
public class ServiceImpl implements Service{

    @Autowired
    private RepositoryImpl repository;

    @Override
    public ArrayList<CharacterResDTO> returnCharaterResDTO(String name) {
        return repository.returnCharacters(name);
    }
}
