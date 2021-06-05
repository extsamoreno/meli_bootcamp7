package com.calculadora.calculadoracalorias.dto;

import lombok.*;


@AllArgsConstructor@NoArgsConstructor
@Setter@Getter
public class PlatoResponseDTO {
    private String nombre;
    private int caloriasTotales;
}
