package com.example.demo.services;

import com.example.demo.DTO.Personaje;

import java.util.List;

public interface IStarWarsServices {

    List<Personaje>  consultarPersonajes(String name);

}
