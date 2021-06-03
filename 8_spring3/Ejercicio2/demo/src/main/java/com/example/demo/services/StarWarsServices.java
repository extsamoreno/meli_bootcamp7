package com.example.demo.services;


import com.example.demo.DTO.Personaje;
import com.example.demo.repository.IStarWarsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StarWarsServices implements  IStarWarsServices{

    @Autowired
    IStarWarsRepository starWarsRepository;

    @Override
    public List<Personaje> consultarPersonajes(String name) {
        return starWarsRepository.consultarPersonajes(name);
    }
}
