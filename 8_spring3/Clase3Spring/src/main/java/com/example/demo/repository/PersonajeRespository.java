package com.example.demo.repository;

import com.example.demo.dto.Personaje;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonajeRespository {
    void obtenerPersonajes();
    List<Personaje> cargarBD();
}
