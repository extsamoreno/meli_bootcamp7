package com.example.demo.repository;

import com.example.demo.DTO.IngredienteDTO;

public interface IPlatoComidaRepository {
     IngredienteDTO buscarIngredienteBD(String name);
}
