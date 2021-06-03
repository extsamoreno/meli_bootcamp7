package com.example.demo.service;


import com.example.demo.entity.Plato;
import com.example.demo.service.dto.IngredienteDTO;

public interface IIngredientesService {

    IngredienteDTO getIngredientesById(Integer id);

    double getCalorias(Plato plato);
}
