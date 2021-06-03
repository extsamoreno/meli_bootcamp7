package com.example.demo.service;

import com.example.demo.entity.Ingrediente;
import com.example.demo.entity.Plato;
import com.example.demo.repository.IIngredientesRepository;
import com.example.demo.service.dto.CaloriasDTO;
import com.example.demo.service.dto.IngredienteDTO;
import com.example.demo.service.mapper.IngredienteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
    @Override
    public List<Ingrediente> getListCalorias(Plato plato) {
        ArrayList<Ingrediente> caloriasingredientes = new ArrayList<>();
        for (IngredienteDTO ingrediente : plato.getIngredientes()) {
            caloriasingredientes.add(iIngredienteRepository.getById(ingrediente.getNombre()));
        }
        return caloriasingredientes;
    }

    @Override
    public CaloriasDTO getMaxCalorias(Plato plato) {
        CaloriasDTO maxCalorie = new CaloriasDTO();
        maxCalorie.setValor(0);
        for (IngredienteDTO ingrediente : plato.getIngredientes()) {
            if (maxCalorie.getValor() < iIngredienteRepository.getById(ingrediente.getNombre()).getCalorias()){
                maxCalorie.setValor(iIngredienteRepository.getById(ingrediente.getNombre()).getCalorias());
                maxCalorie.setIngrediente(iIngredienteRepository.getById(ingrediente.getNombre()).getNombre());
            }
        }
        return maxCalorie;
    }




}
