package com.example.demo.StarWar.Services;

import com.example.demo.StarWar.Repository.Personaje;

import java.util.List;

public interface SearchService {
    public List<Personaje> buscar(String nombre);
}