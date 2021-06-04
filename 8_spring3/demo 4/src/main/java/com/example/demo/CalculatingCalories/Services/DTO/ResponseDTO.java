package com.example.demo.CalculatingCalories.Services.DTO;

import com.example.demo.CalculatingCalories.Repository.Ingrediente;
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

