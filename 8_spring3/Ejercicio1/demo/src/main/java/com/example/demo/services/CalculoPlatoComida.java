package com.example.demo.services;

import com.example.demo.DTO.IngredienteDTO;
import com.example.demo.DTO.PlatoComidaDTO;
import com.example.demo.repository.IPlatoComidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalculoPlatoComida implements  ICalculoPlatoComida{

    @Autowired
    IPlatoComidaRepository platoComidaRepository;

    @Override
    public PlatoComidaDTO calcularPlatoComida(PlatoComidaDTO platoComidaDTO) {

        Integer acumuladorCalorias = 0;
        Integer registroMasCaloria = 0;
        IngredienteDTO ingredienteMasCalorias = new IngredienteDTO();


        for (IngredienteDTO ingredientes: platoComidaDTO.getListaIngredientes()) {
            IngredienteDTO ingredienteBD = platoComidaRepository.buscarIngredienteBD(ingredientes.getName());

            if(ingredienteBD != null){
                ingredientes.setCalories(ingredienteBD.getCalories()) ;
                acumuladorCalorias += ingredientes.getCalories();

                if (ingredientes.getCalories() > registroMasCaloria){
                    registroMasCaloria = ingredientes.getCalories();
                    ingredienteMasCalorias = ingredientes;
                }

            }

        }
        platoComidaDTO.setCaloriaTotales(acumuladorCalorias);
        platoComidaDTO.setIngredienteDTOMasCalorifico(ingredienteMasCalorias);
        return platoComidaDTO;
    }
}
