package com.calculadora.calculadoracalorias.services.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class PlatoRequestDTO {
    private String nombre;
    private ArrayList<IngredientesRequestDTO> ingredientes;
}
