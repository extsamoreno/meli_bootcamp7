package com.example.demo.StarWar.Services;

import com.example.demo.StarWar.Repository.Personaje;
import com.example.demo.StarWar.Repository.PersonajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SearchServiceImpl implements SearchService{

    @Autowired
    PersonajeRepository personajeRepository;

    @Override
    public List<Personaje> buscar(String nombre) {
        return personajeRepository.getMatches(nombre);
    }

}