package com.calculadora.calculadoracalorias.services.dto;

import lombok.*;

import java.util.ArrayList;


@AllArgsConstructor@NoArgsConstructor
@Setter@Getter
public class PlatoResponseDTO {
    private String nombre;
    private int caloriasTotales;
}
