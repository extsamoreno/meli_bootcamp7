package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlatoRepository {

    void obtenerIngredientes();
    List<IngredienteRepository> cargarBaseDeDatos();
}
