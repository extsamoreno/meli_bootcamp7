package com.calculadora.calculadoracalorias.services.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class IngredientesDTO {
    private String nombre;
    private double peso;
}
