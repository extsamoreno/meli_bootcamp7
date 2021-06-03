package com.calorias.calorias.services.dto;
import com.calorias.calorias.repositories.Ingrediente;
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
