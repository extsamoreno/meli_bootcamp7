package com.example.demo.service;

import com.example.demo.entity.Plato;
import com.example.demo.repository.IIngredientesRepository;
import com.example.demo.service.dto.IngredienteDTO;
import com.example.demo.service.mapper.IngredienteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IngredinetesService implements IIngredientesService {

    @Autowired
    IIngredientesRepository iIngredienteRepository;

    @Override
    public IngredienteDTO getIngredientesById(Integer id) {
        return null;
    }

    @Override
    public double getCalorias(Plato plato) {
        double calorias = 0;
        for (IngredienteDTO ingrediente : plato.getIngredientes()) {
            calorias += iIngredienteRepository.getById(ingrediente.getNombre()).getCalorias() * ingrediente.getPeso();
        }
        return calorias;
    }




}
