package com.calculadora.calculadoracalorias.dto;

import lombok.*;

@AllArgsConstructor @NoArgsConstructor
@Setter @Getter
public class IngredienteResponseDTO {
    private String nombre;
    private int calorias;
}
