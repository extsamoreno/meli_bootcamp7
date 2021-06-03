package com.meli.spring.Dto;

import com.meli.spring.Classes.Ingrediente;
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
