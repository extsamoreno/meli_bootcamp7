package com.example.demo.services;

import com.example.demo.dto.Personaje;
import com.example.demo.dto.PersonajeDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PersonajeService {

    String cargarBD();
    List<Personaje> retornarPersonaje(String palabra);
    List<PersonajeDTO> retornarNombres(String palabra);

}
