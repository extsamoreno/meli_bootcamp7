package com.example.exercise.services.dto;
import com.example.exercise.repositories.Ingrediente;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ResponseDTO {
    float caloriasTotales;
    List<Ingrediente> caloriasIngredientes;
    Ingrediente ingrediente;
}