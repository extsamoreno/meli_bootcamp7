package com.example.demo.repository;

import com.example.demo.DTO.Personaje;

import java.util.List;

public interface IStarWarsRepository {

    List<Personaje> consultarPersonajes(String name);
}
