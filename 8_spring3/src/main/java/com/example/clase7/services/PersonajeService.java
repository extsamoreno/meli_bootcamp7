package com.example.clase7.services;

import com.example.clase7.dto.PersonajeRequestDTO;
import com.example.clase7.dto.PersonajeResponseDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public interface PersonajeService {
    ArrayList<PersonajeResponseDTO> obtenerPersonajesPorNombre(PersonajeRequestDTO personaje);
}
