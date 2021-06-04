package com.example.demo.StarWar.Repository;

import java.util.List;

public interface PersonajeRepository {
    List<Personaje> getMatches(String name);
}