package com.example.demo.project.excercise1.service.mapper;

import com.example.demo.project.excercise1.repository.entities.Ingrediente;
import com.example.demo.project.excercise1.service.dto.IngredienteDTO;

public class IngredienteMapper {

    public static IngredienteDTO toDTO(Ingrediente ingrediente){
        return new IngredienteDTO(ingrediente.getName(), ingrediente.getCalories());
    }
}
