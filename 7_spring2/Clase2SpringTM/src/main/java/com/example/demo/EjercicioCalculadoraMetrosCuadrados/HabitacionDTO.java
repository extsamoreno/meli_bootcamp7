package com.example.demo.EjercicioCalculadoraMetrosCuadrados;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HabitacionDTO {
    private String nombre;
    private double metrosCuadrados;
}