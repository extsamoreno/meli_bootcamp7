package com.example.demo.service.mapper;

import com.example.demo.entity.Ingrediente;
import com.example.demo.service.dto.IngredienteDTO;

public class IngredienteMapper {


    public static IngredienteDTO toDTO(Ingrediente ingrediente){
        return new IngredienteDTO(ingrediente.getNombre(), ingrediente.getCalorias());
    }

}
