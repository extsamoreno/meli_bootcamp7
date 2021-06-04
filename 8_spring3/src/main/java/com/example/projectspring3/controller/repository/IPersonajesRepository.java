package com.example.projectspring3.controller.repository;

import com.example.projectspring3.controller.service.PersonajesDTO;

import java.util.List;

public interface IPersonajesRepository {
    public List<String> getPersonajeByName(String nombre);
}
