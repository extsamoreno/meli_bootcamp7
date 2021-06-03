package com.example.demo.service;


import com.example.demo.entity.Ingrediente;
import com.example.demo.entity.Plato;
import com.example.demo.service.dto.CaloriasDTO;
import com.example.demo.service.dto.IngredienteDTO;

import java.util.List;

public interface IIngredientesService {

    IngredienteDTO getIngredientesById(Integer id);

    double getCalorias(Plato plato);

    List<Ingrediente> getListCalorias(Plato plato);

    CaloriasDTO getMaxCalorias(Plato plato);
}
