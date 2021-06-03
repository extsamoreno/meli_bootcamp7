package com.meli.spring.PracticaMañana.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class PlatoDto {
    private String nombre;
    private float caloriasTotal;
    private List<IngredienteDto> ingredienteDtoList;
    private IngredienteDto ingredienteMasCalorias;

}
