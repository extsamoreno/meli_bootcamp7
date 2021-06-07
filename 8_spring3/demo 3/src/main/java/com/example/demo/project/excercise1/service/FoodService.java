package com.example.demo.project.excercise1.service;

import com.example.demo.project.excercise1.repository.*;
import com.example.demo.project.excercise1.repository.entities.Ingrediente;
import com.example.demo.project.excercise1.repository.entities.Plato;
import com.example.demo.project.excercise1.repository.entities.Platos;
import com.example.demo.project.excercise1.service.dto.PlatoDTO;
import com.example.demo.project.excercise1.service.dto.PlatosDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FoodService implements IFoodService {

    @Autowired
    IFoodRepository iFoodRepository;

    @Override
    public PlatosDTO getAllPlatosCalorias(Platos platos){

        List<PlatoDTO> platosListaDTO = new ArrayList<>();

        for(Plato p : platos.getPlatos()){
            platosListaDTO.add(getPlatoCalorias(p));
        }

        return new PlatosDTO(platosListaDTO);
    }

    @Override
    public PlatoDTO getPlatoCalorias(Plato plato) {
        List<Ingrediente> ingredienteLoad = new ArrayList<>();//
        List<Ingrediente> ingredientes = plato.getIngredientes();
        PlatoDTO platoDTO1 = new PlatoDTO();
        int caloriasPorPlato = 0;
        Integer theMostCaloric = 0;

        for (Ingrediente ingr : ingredientes){
            Ingrediente ingredienteTemporal = iFoodRepository.getById(ingr.getName());
            ingr.setCalories(ingr.getWeight() * ingredienteTemporal.getCalories());
            if(ingr.getCalories() > theMostCaloric){
                platoDTO1.setTheMostCaloric(ingr);
            }
            theMostCaloric = ingr.getCalories();
            caloriasPorPlato += ingr.getCalories();
            ingredienteLoad.add(ingr);
        }

        //platoDTO1 = PlatoMapper.toDTO(plato.getName(), caloriasPorPlato);
        // TODO: mapear lista de ingredientes a lista dto
        // TODO: mapear plato a plato dto

        platoDTO1.setCalorias(caloriasPorPlato);
        platoDTO1.setName(plato.getName());
        platoDTO1.setIngredientes(ingredienteLoad);


        return platoDTO1;
    }

}

