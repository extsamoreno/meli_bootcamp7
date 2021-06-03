package com.calorias.calorias.services;
import com.calorias.calorias.repositories.Ingrediente;
import com.calorias.calorias.repositories.IngredienteRepository;
import com.calorias.calorias.repositories.Plato;
import com.calorias.calorias.services.dto.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CalculateServiceImpl implements CalculateService {


    @Autowired
    IngredienteRepository ingredienteRepository;

    @Override
    public ResponseDTO calculate(Plato plato) {

        return new ResponseDTO(
                caloriasTotales(plato),
                caloriasIngredientes(plato),
                ingredienteMasCaloria(plato)
        );
    }

    @Override
    public List<ResponseDTO> calculate(List<Plato> platos) {
        List<ResponseDTO> responseDTOS = new ArrayList<ResponseDTO>(platos.size());

        for (Plato plato: platos
             ) {
            responseDTOS.add(
                    calculate(plato)
            );
        }

        return responseDTOS;
    }

    public Ingrediente ingredienteMasCaloria(Plato plato){
        Ingrediente ingredienteMayor = new Ingrediente();
        ingredienteMayor.setCalories(0);

        for (Ingrediente ingrediente: plato.getIngredientes()
             ) {
            if( ingredienteMayor.getCalories() < ingrediente.getCalories() ){
                ingredienteMayor = ingrediente;
            }
        }
        return ingredienteMayor;
    }

    public List<Ingrediente> caloriasIngredientes(Plato plato ){

        for (Ingrediente ingrediente : plato.getIngredientes()
             ) {
            ingrediente.setCalories(
                    ingredienteRepository.findIngredienteByName(ingrediente.getName()).getCalories()
            );
        }

        return plato.getIngredientes();
    }

    public float caloriasTotales(Plato plato){

        float totalCalorias = 0;

        for (Ingrediente ingrediente : plato.getIngredientes()
             ) {
            float ingredientePeso = ingrediente.getPeso()/100f;
            totalCalorias += ingredienteRepository.findIngredienteByName(ingrediente.getName()).getCalories() * ingredientePeso;
        }
        return totalCalorias;

    }

}
